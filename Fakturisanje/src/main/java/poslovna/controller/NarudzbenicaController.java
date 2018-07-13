package poslovna.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.NarudzbenicaToNarudzbenicaDTOConverter;
import poslovna.model.FiskalnaGodina;
import poslovna.model.NacinPlacanja;
import poslovna.model.Narudzbenica;
import poslovna.model.PoslovniPartner;
import poslovna.model.Radnik;
import poslovna.service.FiskalnaGodinaService;
import poslovna.service.NacinPlacanjaService;
import poslovna.service.NarudzbenicaService;
import poslovna.service.PoslovniPartnerService;
import poslovna.service.RadnikService;

@RestController
@RequestMapping(value = "/narudzbenica")
public class NarudzbenicaController {
	
	@Autowired
	private  NarudzbenicaService narudzbenicaService;
	
	@Autowired
	private RadnikService radnikService;
	
	@Autowired
	private PoslovniPartnerService poslovniPartnerService; 
	
	@Autowired
	private FiskalnaGodinaService fiskalnaGodinaService;
	
	@Autowired
	private NacinPlacanjaService nacinPlacanjaService;
	
	@Autowired
	private NarudzbenicaToNarudzbenicaDTOConverter narudzbenicaToNarudzbenicaDTOConverter;
	
	@RequestMapping(
			value = "/getAllByPP/{idPP}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByPP(@PathVariable Long idPP) {
		
		Long idKompanije = radnikService.getCurrentUser().getKompanija().getId();
		List<Narudzbenica> narudzbenica = narudzbenicaService.findByPoslovniPartnerIdAndKompanijaID(idPP,idKompanije);
		
		return new ResponseEntity<>(narudzbenicaToNarudzbenicaDTOConverter.convert(narudzbenica), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/createNew/{idPP}/{idNacinaPlacanja}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> createNew(@PathVariable Long idPP, @PathVariable Long idNacinaPlacanja) {
		Radnik ulogovani = radnikService.getCurrentUser();
		PoslovniPartner poslovniPartner = poslovniPartnerService.findById(idPP);
		NacinPlacanja nacinPlacanja = nacinPlacanjaService.findOne(idNacinaPlacanja);
		if(ulogovani != null && poslovniPartner != null && nacinPlacanja != null) {
			FiskalnaGodina fiskalnaGodina = fiskalnaGodinaService.findByKompanijaAndAktivna(ulogovani.getKompanija().getId());
			
			Narudzbenica narudzbenica = new Narudzbenica();
			narudzbenica.setBrojNarudzbenice(0);
			narudzbenica.setDatumNarudzbenica(new Date());
			narudzbenica.setKompanija(ulogovani.getKompanija());
			narudzbenica.setPoslovniPartner(poslovniPartner);
			narudzbenica.setPoslata(false);
			narudzbenica.setFiskalnaGodina(fiskalnaGodina);
			narudzbenica.setUkupanPDV(0.0);
			narudzbenica.setUkupnaCena(0.0);
			narudzbenica.setUkupnaCenaBezPDVa(0.0);
			narudzbenica.setNacinPlacanja(nacinPlacanja);
			
			if(nacinPlacanja.getNazivTipaPlacanja().equals("racun")) {
				narudzbenica.setPozivNaBroj(poslovniPartner.getPozivNaBroj());
				narudzbenica.setRacunZaUplatu(poslovniPartner.getRacunZaUplatu());
			}
			
			Narudzbenica sacuvana = narudzbenicaService.save(narudzbenica);
			sacuvana.setBrojNarudzbenice(sacuvana.getId().intValue());
			sacuvana = narudzbenicaService.save(sacuvana);
			
			return new ResponseEntity<>(narudzbenicaToNarudzbenicaDTOConverter.convert(sacuvana), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	
	@RequestMapping(
			value = "/delete/{idNarudzbenice}",
			method = RequestMethod.DELETE
	)
	public ResponseEntity<?> delete(@PathVariable Long idNarudzbenice) {
		narudzbenicaService.delete(idNarudzbenice);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getPrimljeneNarudzbenice/{idPP}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getPrimljeneNarudzbenice(@PathVariable Long idPP) {
		Long idKompanije = radnikService.getCurrentUser().getKompanija().getId();
		List<Narudzbenica> narudzbenica = narudzbenicaService.findByPoslovniPartnerIdAndKompanijaIDAndOdKupcaAndPoslata(idPP,idKompanije, true, false);
		
		return new ResponseEntity<>(narudzbenicaToNarudzbenicaDTOConverter.convert(narudzbenica), HttpStatus.OK);

	}
	
}
