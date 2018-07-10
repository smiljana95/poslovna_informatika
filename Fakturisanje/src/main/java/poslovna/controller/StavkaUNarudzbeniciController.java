package poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.model.Artikal;
import poslovna.model.MagacinskaKartica;
import poslovna.model.Narudzbenica;
import poslovna.model.StavkaUCenovniku;
import poslovna.model.StavkaUNarudzbenici;
import poslovna.service.ArtikalService;
import poslovna.service.MagacinskaKarticaService;
import poslovna.service.NarudzbenicaService;
import poslovna.service.StavkaUCenovnikuService;
import poslovna.service.StavkaUNarudzbeniciService;

@RestController
@RequestMapping(value = "/stavkaUNarudzbenici")
public class StavkaUNarudzbeniciController {

	@Autowired
	private StavkaUNarudzbeniciService stavkaUNarudzbeniciService;
	
	@Autowired
	private StavkaUCenovnikuService stavkaUCenovnikuService;
	
	@Autowired
	private MagacinskaKarticaService magacinskaKarticaService;
	
	@Autowired
	private NarudzbenicaService narudzbenicaService;
	
	@Autowired
	private ArtikalService artikalService;
	
	@RequestMapping(
			value = "/dodajStavku/{idPP}/{idNarudzbenice}/{idArtikla}/{idCenovnika}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> dodajStavku(@RequestBody String kolicina, @PathVariable Long idPP, @PathVariable Long idNarudzbenice, @PathVariable Long idArtikla, @PathVariable Long idCenovnika ) {
		int kol = 0;
		try {
			kol = Integer.parseInt(kolicina);
		} catch (Exception e) {
			return new ResponseEntity<>("Uneti broj za kolicinu.", HttpStatus.BAD_REQUEST);
		}
		
		if(kol < 0) {
			return new ResponseEntity<>("Kolicina mora biti pozitivan broj.", HttpStatus.BAD_REQUEST);
		}
		
		StavkaUCenovniku stavkaUCenovniku = stavkaUCenovnikuService.findByArtikalIdAndCenovnikId(idArtikla,idCenovnika);
		
		
		MagacinskaKartica magacinskaKartica = magacinskaKarticaService.findByArtikalIdAndPoslovniPartnerId(idArtikla,idPP);
		if(magacinskaKartica == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(magacinskaKartica.getKolicna() - kol >= 0){
			magacinskaKartica.setKolicna(magacinskaKartica.getKolicna()-kol);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Artikal artikal = artikalService.findById(idArtikla);
		Narudzbenica narudzbenica = narudzbenicaService.findById(idNarudzbenice);
		if(narudzbenica!=null && artikal != null){
			StavkaUNarudzbenici stavkaPronadjena = stavkaUNarudzbeniciService.fincByArtikalAndNarudzbenica(idArtikla, idNarudzbenice);
			
			if(stavkaPronadjena == null) {
				StavkaUNarudzbenici stavka = new StavkaUNarudzbenici();
				stavka.setJedinicnaCena(stavkaUCenovniku.getCena());
				stavka.setPopust(stavkaUCenovniku.getPopust());
				stavka.setOsnovica(((kol * stavka.getJedinicnaCena())*(100.0 - stavka.getPopust()))/100.0);
				int pdvUProcentima = Integer.parseInt(artikal.getGrupaArtikala().getTipPDVa().getStopaPDVa().getPDVuProcentima());
				stavka.setIznosPDVa((stavka.getOsnovica() * (pdvUProcentima))/100.0);
				stavka.setStopaPDVa(pdvUProcentima);
				stavka.setJedinicnaCenaSaPDV(stavka.getOsnovica() + stavka.getIznosPDVa());
				stavka.setArtikal(artikal);
				stavka.setUkupnaKolicina(kol);
				
				narudzbenica.setUkupanPDV(narudzbenica.getUkupanPDV() + ((stavka.getOsnovica() * (pdvUProcentima))/100.0));
				narudzbenica.setUkupnaCenaBezPDVa(narudzbenica.getUkupnaCenaBezPDVa() + stavka.getOsnovica());
				narudzbenica.setUkupnaCena(narudzbenica.getUkupnaCena() + stavka.getJedinicnaCenaSaPDV());
				
				stavka.setNarudzbenica(narudzbenica);
				stavkaUNarudzbeniciService.save(stavka);
				narudzbenicaService.save(narudzbenica);
			} else {
				stavkaPronadjena.setJedinicnaCena(stavkaUCenovniku.getCena());
				stavkaPronadjena.setPopust(stavkaUCenovniku.getPopust());
				stavkaPronadjena.setOsnovica(((kol * stavkaPronadjena.getJedinicnaCena())*(100.0 - stavkaPronadjena.getPopust()))/100.0);
				int pdvUProcentima = Integer.parseInt(artikal.getGrupaArtikala().getTipPDVa().getStopaPDVa().getPDVuProcentima());
				stavkaPronadjena.setIznosPDVa((stavkaPronadjena.getOsnovica() * (pdvUProcentima))/100.0);
				stavkaPronadjena.setStopaPDVa(pdvUProcentima);
				stavkaPronadjena.setJedinicnaCenaSaPDV(stavkaPronadjena.getOsnovica() + stavkaPronadjena.getIznosPDVa());
				stavkaPronadjena.setArtikal(artikal);
				stavkaPronadjena.setUkupnaKolicina(kol);
				
				narudzbenica.setUkupanPDV(narudzbenica.getUkupanPDV() + ((stavkaPronadjena.getOsnovica() * (pdvUProcentima))/100.0));
				narudzbenica.setUkupnaCenaBezPDVa(narudzbenica.getUkupnaCenaBezPDVa() + stavkaPronadjena.getOsnovica());
				narudzbenica.setUkupnaCena(narudzbenica.getUkupnaCena() + stavkaPronadjena.getJedinicnaCenaSaPDV());
				
				stavkaPronadjena.setNarudzbenica(narudzbenica);
				stavkaUNarudzbeniciService.save(stavkaPronadjena);
				narudzbenicaService.save(narudzbenica);
			}
		}
				
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
