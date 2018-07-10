package poslovna.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.ArtikalToArtikalDTOConverter;
import poslovna.converter.CenovnikToCenovnikDTOConverter;
import poslovna.dto.CenovnikDTO;
import poslovna.dto.KopiranjeCenovnikaDTO;
import poslovna.dto.StavkaCenovnikaDTO;
import poslovna.model.Artikal;
import poslovna.model.Cenovnik;
import poslovna.model.StavkaUCenovniku;
import poslovna.service.ArtikalService;
import poslovna.service.CenovnikService;
import poslovna.service.StavkaUCenovnikuService;

@RestController
@RequestMapping(value = "/cenovnik")
public class CenovnikController {
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@Autowired
	private CenovnikToCenovnikDTOConverter cenovnikToCenovnikDTOConverter;
	
	@Autowired
	private StavkaUCenovnikuService stavkaService;
	
	@Autowired
	private ArtikalService artikalService;
	
	@Autowired
	private ArtikalToArtikalDTOConverter artikalToArtikalDTOConverter;
	
	@RequestMapping(
			value = "/getByPP/{idPP}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByPP(@PathVariable Long idPP) {
		Cenovnik aktuelni = cenovnikService.findByPoslovniPartnerIdAndAktivan(idPP);
		
		return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(aktuelni), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getByKompanija/{idKompanije}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByKompanija(@PathVariable Long idKompanije) {
		return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(cenovnikService.findByKompanija(idKompanije)), HttpStatus.OK);

	}
	@RequestMapping(
			value = "/getCenovnikZaPrikaz/{idCenovnika}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getCenovnikZaPrikaz(@PathVariable Long idCenovnika) {
		Cenovnik zaPrikaz = cenovnikService.findById(idCenovnika);
		
		return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(zaPrikaz), HttpStatus.OK);
	}
	@RequestMapping(
			value = "/obrisiStavku",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> obrisiStavku(@RequestBody StavkaCenovnikaDTO zaBrisanje) {
		Cenovnik cenovnikStavke = cenovnikService.findById(zaBrisanje.getIdCenovnika());
		for(int i = 0; i < cenovnikStavke.getStavkeUCenovniku().size(); i++){
			if(cenovnikStavke.getStavkeUCenovniku().get(i).getId().equals(zaBrisanje.getId())){
				cenovnikStavke.getStavkeUCenovniku().remove(i);
				break;
			}
		}
		
		stavkaService.delete(zaBrisanje.getId());
		cenovnikService.save(cenovnikStavke);
		return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(cenovnikStavke), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/izlistajArtikle",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> izlistajArtikle() {
		
		ArrayList<Artikal> sviArtikli = (ArrayList<Artikal>) artikalService.findAll();
		return new ResponseEntity<>(artikalToArtikalDTOConverter.convert(sviArtikli), HttpStatus.OK);
	}
	@RequestMapping(
			value = "/dodajStavku",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> dodajStavku(@RequestBody StavkaCenovnikaDTO zaDodavanje) {
		Cenovnik cenovnikStavke = cenovnikService.findById(zaDodavanje.getIdCenovnika());
		StavkaUCenovniku stavkaZaDodavanje = new StavkaUCenovniku();
		stavkaZaDodavanje.setCena(zaDodavanje.getCena());
		Artikal artikalStavke = artikalService.findById(zaDodavanje.getId());
		stavkaZaDodavanje.setArtikal(artikalStavke);
		stavkaZaDodavanje.setCenovnik(cenovnikStavke);
		cenovnikStavke.getStavkeUCenovniku().add(stavkaZaDodavanje);
		
		stavkaService.save(stavkaZaDodavanje);
		cenovnikService.save(cenovnikStavke);
		return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(cenovnikStavke), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/promeniAktivan",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> promeniAktivan(@RequestBody CenovnikDTO noviAktivan) {
		Cenovnik noviAktivanCenovik = cenovnikService.findById(noviAktivan.getId());
		ArrayList<Cenovnik> sviCenovniciKompanije = (ArrayList<Cenovnik>) cenovnikService.findByKompanija(noviAktivan.getIdKompanije());
		//deaktiviraj stari aktivan cenovnik
		for(Cenovnik c : sviCenovniciKompanije){
			if(c.isAktivan()){
				c.setAktivan(false);
				cenovnikService.save(c);
				break;
				
			}
		}
		noviAktivanCenovik.setAktivan(true);
		cenovnikService.save(noviAktivanCenovik);
		return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(cenovnikService.findByKompanija(noviAktivan.getIdKompanije())), HttpStatus.OK);
	}
	@RequestMapping(
			value = "/kopiranjeCenovnika",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> kopiranjeCenovnika(@RequestBody KopiranjeCenovnikaDTO zaKopiranje) {
		Long id = zaKopiranje.getIdCenovnika();
		Cenovnik cenovnikStavke = cenovnikService.findById(id);
		
		Cenovnik noviCenovnik = new Cenovnik();
		noviCenovnik.setAktivan(false);
		
		noviCenovnik.setDatum_pocetka_vazenja(cenovnikStavke.getDatum_pocetka_vazenja());
		noviCenovnik.setKompanija(cenovnikStavke.getKompanija());
		noviCenovnik.setPoslovniPartner(cenovnikStavke.getPoslovniPartner());
		noviCenovnik.setStavkeUCenovniku(new ArrayList<StavkaUCenovniku>());
		Cenovnik saved = cenovnikService.save(noviCenovnik);

		double procenat = zaKopiranje.getProcenat();
		
		for(int i=0; i< cenovnikStavke.getStavkeUCenovniku().size(); i++){
			StavkaUCenovniku stavka = new StavkaUCenovniku();
			stavka.setCenovnik(saved);
			stavka.setPopust(cenovnikStavke.getStavkeUCenovniku().get(i).getPopust());
			stavka.setArtikal(cenovnikStavke.getStavkeUCenovniku().get(i).getArtikal());
			stavka.setCena(cenovnikStavke.getStavkeUCenovniku().get(i).getCena() * procenat /100);
			stavkaService.save(stavka);
			saved.getStavkeUCenovniku().add(stavka);
		
		}
		
		cenovnikService.save(saved);
		
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
