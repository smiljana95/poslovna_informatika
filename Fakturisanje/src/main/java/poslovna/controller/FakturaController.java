package poslovna.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.shibboleth.utilities.java.support.security.DataSealerKeyStrategy;
import poslovna.converter.FakturaToFakturaDTOConverter;
import poslovna.dto.FakturaDTO;
import poslovna.dto.NarucenaStavkaDTO;
import poslovna.dto.NovaFakturaDTO;
import poslovna.model.Artikal;
import poslovna.model.Cenovnik;
import poslovna.model.Faktura;
import poslovna.model.NacinPlacanja;
import poslovna.model.Narudzbenica;
import poslovna.model.PoslovniPartner;
import poslovna.model.Radnik;
import poslovna.model.StavkaUCenovniku;
import poslovna.model.StavkaUFakturi;
import poslovna.model.StavkaUNarudzbenici;
import poslovna.service.CenovnikService;
import poslovna.service.FakturaService;
import poslovna.service.FiskalnaGodinaService;
import poslovna.service.NacinPlacanjaService;
import poslovna.service.NarudzbenicaService;
import poslovna.service.PoslovniPartnerService;
import poslovna.service.RadnikService;
import poslovna.service.StavkaUCenovnikuService;
import poslovna.service.StavkaUFakturiService;

@RestController
@RequestMapping(value = "/faktura")
public class FakturaController {
	
	@Autowired
	private FakturaService fakturaService;
	
	@Autowired
	private NarudzbenicaService narudzbenicaService;
	
	@Autowired
	private StavkaUFakturiService stavkaUFakturiService;
	
	@Autowired
	private FakturaToFakturaDTOConverter fakturaToFakturaDTOConverter;
	
	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	private NacinPlacanjaService nacinPlacanjaService;
	
	@Autowired
	private StavkaUCenovnikuService stavkaUCenovnikuService;
	
	@Autowired
	private RadnikService radnikService;
	
	@Autowired
	private FiskalnaGodinaService fiskalnaGodinaService;
	
	@RequestMapping(
			value = "/kreirajFakturuIzNarudzbenice/{idNarudzbenice}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByPP(@PathVariable Long idNarudzbenice) {
		
		//kad se od narudzbenice kreira faktura, narudzbenica postaje poslata
		Narudzbenica narudzbenica = narudzbenicaService.findById(idNarudzbenice);
		narudzbenica.setPoslata(true);
		narudzbenicaService.save(narudzbenica);
		
		
		Faktura faktura = new Faktura();
		
		//datum valute = datum fakture + 1 godina
		faktura.setDatumFakture(narudzbenica.getDatumNarudzbenica());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(faktura.getDatumFakture());
		calendar.add(Calendar.YEAR, 1);
		
		Date datumValute = calendar.getTime(); 
		
		faktura.setBrojFakture(narudzbenica.getBrojNarudzbenice());
		faktura.setFiskalnaGodina(narudzbenica.getFiskalnaGodina());
		faktura.setKompanija(narudzbenica.getKompanija());
		faktura.setNacinPlacanja(narudzbenica.getNacinPlacanja());
		faktura.setPoslovniPartner(narudzbenica.getPoslovniPartner());
		
		if(narudzbenica.getNacinPlacanja().getNazivTipaPlacanja().equals("racun")){
			faktura.setPozivNaBroj(narudzbenica.getPozivNaBroj());
			faktura.setRacunZaUplatu(narudzbenica.getRacunZaUplatu());
		}
		
		
		faktura.setUkupanPDV(narudzbenica.getUkupanPDV());
		faktura.setUkupnaCena(narudzbenica.getUkupnaCena());
		faktura.setUkupnaCenaBezPDVa(narudzbenica.getUkupnaCenaBezPDVa());
		
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String datumValuteString = df.format(datumValute);
		
		@SuppressWarnings("deprecation")
		Date datumValuteNovo = new Date(datumValuteString);
		faktura.setDatumValute(datumValuteNovo );
		fakturaService.save(faktura);
	
		for(StavkaUNarudzbenici stavkaUNarudzbenici : narudzbenica.getStavke()){
			StavkaUFakturi stavkaUFakturi = new StavkaUFakturi();
			stavkaUFakturi.setArtikal(stavkaUNarudzbenici.getArtikal());
			stavkaUFakturi.setFaktura(faktura);
			stavkaUFakturi.setIznosPDVa(stavkaUNarudzbenici.getIznosPDVa());
			stavkaUFakturi.setJedinicnaCena(stavkaUNarudzbenici.getJedinicnaCena());
			stavkaUFakturi.setJedinicnaCenaSaPDVa(stavkaUNarudzbenici.getJedinicnaCenaSaPDV());
			stavkaUFakturi.setOsnovica(stavkaUNarudzbenici.getOsnovica());
			stavkaUFakturi.setPopust(stavkaUNarudzbenici.getPopust());
			stavkaUFakturi.setStopaPDVa(stavkaUNarudzbenici.getStopaPDVa());
			stavkaUFakturi.setUkupnaKolicina(stavkaUNarudzbenici.getUkupnaKolicina());
			stavkaUFakturiService.save(stavkaUFakturi);
			
		}
		
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getAllFakture",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getAllFakture() {
		List<Faktura> fakture = fakturaService.findAll();
		return new ResponseEntity<>(fakturaToFakturaDTOConverter.convert(fakture), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/obrisiFakturu/{idFakture}",
			method = RequestMethod.DELETE
	)
	public ResponseEntity<?> obrisiFakturu(@PathVariable Long idFakture) {
		fakturaService.delete(idFakture);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(
			value = "/eksportujFakturu/{idFakture}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> eksportujFakturu(@PathVariable Long idFakture) {
		Faktura toEksport = fakturaService.findById(idFakture);
		FakturaDTO toEksportDTO = fakturaToFakturaDTOConverter.convert(toEksport);
		File file = new File("fileFaktura"+idFakture+".xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(FakturaDTO.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(toEksportDTO, file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/getPrimljeneFakture/{idFakture}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getPrimljeneFakture(@PathVariable Long idFakture) {
		List<Faktura> fakturePrimljene = fakturaService.findByOtpremljena(false);
		List<FakturaDTO> fakturePrimljeneDTO = fakturaToFakturaDTOConverter.convert(fakturePrimljene);
			return new ResponseEntity<>(fakturePrimljeneDTO,HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/kreairajDirektno",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> kreairajDirektno(@RequestBody NovaFakturaDTO novaFakturaDTO) {
		
		if(novaFakturaDTO.getIdNacinaPlacanja() == null || novaFakturaDTO.getIdPartnera() == null) {
			return new ResponseEntity<>("Popuniti sve podatke", HttpStatus.BAD_REQUEST);
		}
		
		Radnik ulogovani = radnikService.getCurrentUser();
		PoslovniPartner poslovniPartner = poslovniPartnerService.findById(novaFakturaDTO.getIdPartnera());
		NacinPlacanja nacinPlacanja = nacinPlacanjaService.findOne(novaFakturaDTO.getIdNacinaPlacanja());
		
		if(poslovniPartner != null && nacinPlacanja != null && ulogovani != null) {
			Faktura faktura = new Faktura();
			faktura.setDatumFakture(new Date());
			Calendar c = Calendar.getInstance();
			c.add(Calendar.YEAR, 1);
			faktura.setDatumValute(c.getTime());
			faktura.setPoslovniPartner(poslovniPartner);
			faktura.setOtpremljena(false);
			faktura.setFiskalnaGodina(fiskalnaGodinaService.findByKompanijaAndAktivna(ulogovani.getKompanija().getId()));
			faktura.setKompanija(ulogovani.getKompanija());
			faktura.setNacinPlacanja(nacinPlacanja);
			
			if(nacinPlacanja.getNazivTipaPlacanja().equals("racun")){
				faktura.setPozivNaBroj(poslovniPartner.getPozivNaBroj());
				faktura.setRacunZaUplatu(poslovniPartner.getRacunZaUplatu());
			}
			
			Faktura sacuvana = fakturaService.save(faktura);
			
			for(NarucenaStavkaDTO narucenaStavka : novaFakturaDTO.getStavke()) {
				if(narucenaStavka.getValue() > 0) {
					StavkaUCenovniku stavkaUCenovniku = stavkaUCenovnikuService.findById(narucenaStavka.getId());
					Artikal artikal = stavkaUCenovniku.getArtikal();
					StavkaUFakturi stavkaUFakturi = new StavkaUFakturi();
					stavkaUFakturi.setFaktura(sacuvana);
					stavkaUFakturi.setArtikal(artikal);
					stavkaUFakturi.setJedinicnaCena(stavkaUCenovniku.getCena());
					stavkaUFakturi.setPopust(stavkaUCenovniku.getPopust());
					stavkaUFakturi.setOsnovica(((narucenaStavka.getValue() * stavkaUFakturi.getJedinicnaCena())*(100.0 - stavkaUFakturi.getPopust()))/100.0);
					int pdvUProcentima = Integer.parseInt(artikal.getGrupaArtikala().getTipPDVa().getStopaPDVa().getPDVuProcentima());
					stavkaUFakturi.setIznosPDVa((stavkaUFakturi.getOsnovica() * (pdvUProcentima))/100.0);
					stavkaUFakturi.setStopaPDVa(pdvUProcentima);
					stavkaUFakturi.setJedinicnaCenaSaPDVa(stavkaUFakturi.getOsnovica() + stavkaUFakturi.getIznosPDVa());
					stavkaUFakturi.setUkupnaKolicina(narucenaStavka.getValue());
					
					StavkaUFakturi sacuvanaStavka = stavkaUFakturiService.save(stavkaUFakturi);
					
					sacuvana.getStavke().add(sacuvanaStavka);
				}
			}
			
			double ukupanPdv = 0.0;
			double ukupnaCenaBezPdva = 0.0;
			double ukupnaCena = 0.0;
			
			for(int i=0; i<sacuvana.getStavke().size(); i++){
				ukupanPdv += sacuvana.getStavke().get(i).getIznosPDVa();
				ukupnaCenaBezPdva += sacuvana.getStavke().get(i).getOsnovica();
				ukupnaCena += sacuvana.getStavke().get(i).getJedinicnaCenaSaPDVa();
			}
			sacuvana.setUkupanPDV(ukupanPdv);
			sacuvana.setUkupnaCenaBezPDVa(ukupnaCenaBezPdva);
			sacuvana.setUkupnaCena(ukupnaCena);
			sacuvana.setBrojFakture(sacuvana.getId().intValue());
			
			sacuvana = fakturaService.save(sacuvana);
			return new ResponseEntity<>(fakturaToFakturaDTOConverter.convert(sacuvana), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
