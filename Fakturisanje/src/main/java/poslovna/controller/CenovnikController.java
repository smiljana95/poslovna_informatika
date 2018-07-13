package poslovna.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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
		ArrayList<Cenovnik> cenovnici = (ArrayList<Cenovnik>) cenovnikService.findByKompanija(1L);
		
		Collections.sort(cenovnici, new Comparator<Cenovnik>() {
			
			@Override
			public int compare(Cenovnik arg0, Cenovnik arg1) {
				return arg0.getDatum_pocetka_vazenja().compareTo(arg1.getDatum_pocetka_vazenja());
			}
			});
		boolean setted = false;
		for(int i = 0; i < cenovnici.size(); i++){
			cenovnici.get(i).setAktivan(false);
		}
		for(int i = 0; i < cenovnici.size(); i++){
			if(cenovnici.get(i).getDatum_pocetka_vazenja().after(new Date())){
				if(i>0){
					int brAktivnog = i-1;
					cenovnici.get(brAktivnog).setAktivan(true);
					cenovnikService.save(cenovnici.get(brAktivnog));
					setted = true;
					break;
				}else{
					cenovnici.get(0).setAktivan(true);
					cenovnikService.save(cenovnici.get(0));
					setted = true;
					break;
				}
			}
		}
		if(!setted){
			cenovnici.get(cenovnici.size()-1).setAktivan(true);
			cenovnikService.save(cenovnici.get(cenovnici.size()-1));
		}
	return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(cenovnici), HttpStatus.OK);
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
	public ResponseEntity<?> kopiranjeCenovnika(@RequestBody KopiranjeCenovnikaDTO zaKopiranje) throws ParseException {
		Long id = zaKopiranje.getIdCenovnika();
		Cenovnik cenovnikStavke = cenovnikService.findById(id);
		if(zaKopiranje.getProcenat()==0){
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
		Cenovnik noviCenovnik = new Cenovnik();
		noviCenovnik.setAktivan(false);
		String datum = zaKopiranje.getDatum() + " 00:00:00";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		noviCenovnik.setDatum_pocetka_vazenja((dateFormat.parse(datum)));
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
			stavka.setCena(cenovnikStavke.getStavkeUCenovniku().get(i).getCena() *  procenat/100);
			stavkaService.save(stavka);
			saved.getStavkeUCenovniku().add(stavka);
		
		}
		
		cenovnikService.save(saved);
		
		return new ResponseEntity<>( HttpStatus.OK);
	}
	@RequestMapping(
			value = "/podesiAktivan",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> podesiAktivan(){
		ArrayList<Cenovnik> cenovnici = (ArrayList<Cenovnik>) cenovnikService.findByKompanija(1L);
		
		Collections.sort(cenovnici, new Comparator<Cenovnik>() {
			
			@Override
			public int compare(Cenovnik arg0, Cenovnik arg1) {
				return arg0.getDatum_pocetka_vazenja().compareTo(arg1.getDatum_pocetka_vazenja());
			}
			});
		boolean setted = false;
		for(int i = 0; i < cenovnici.size(); i++){
			cenovnici.get(i).setAktivan(false);
		}
		for(int i = 0; i < cenovnici.size(); i++){
			if(cenovnici.get(i).getDatum_pocetka_vazenja().after(new Date())){
				if(i>0){
					int brAktivnog = i-1;
					cenovnici.get(brAktivnog).setAktivan(true);
					cenovnikService.save(cenovnici.get(brAktivnog));
					setted = true;
					break;
				}else{
					cenovnici.get(0).setAktivan(true);
					cenovnikService.save(cenovnici.get(0));
					setted = true;
					break;
				}
			}
		}
		if(!setted){
			cenovnici.get(cenovnici.size()-1).setAktivan(true);
			cenovnikService.save(cenovnici.get(cenovnici.size()-1));
		}
	return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(cenovnici), HttpStatus.OK);
	}
}
