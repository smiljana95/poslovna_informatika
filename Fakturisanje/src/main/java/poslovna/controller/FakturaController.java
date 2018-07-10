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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.FakturaToFakturaDTOConverter;
import poslovna.dto.FakturaDTO;
import poslovna.model.Faktura;
import poslovna.model.Narudzbenica;
import poslovna.model.StavkaUFakturi;
import poslovna.model.StavkaUNarudzbenici;
import poslovna.service.FakturaService;
import poslovna.service.NarudzbenicaService;
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
			stavkaUFakturi.setJedinicnaCenaBezPDVa(stavkaUNarudzbenici.getJedinicnaCenaSaPDV());
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

}
