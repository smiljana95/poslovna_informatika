package poslovna.controller;

import java.io.File;
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

import poslovna.converter.OtpremnicaToOtpremnicaDTOConverter;
import poslovna.dto.OtpremnicaDTO;
import poslovna.model.Faktura;
import poslovna.model.Otpremnica;
import poslovna.model.StavkaUFakturi;
import poslovna.model.StavkaUOtpremnici;
import poslovna.service.FakturaService;
import poslovna.service.OtpremnicaService;
import poslovna.service.StavkaUOtpremniciService;

@RestController
@RequestMapping(value = "/otpremnica")
public class OtpremnicaController {
	
	@Autowired
	private OtpremnicaService otpremnicaService;
	
	@Autowired
	private FakturaService fakturaService;
	
	@Autowired
	private OtpremnicaToOtpremnicaDTOConverter otpremnicaConverter;
	
	@Autowired
	private StavkaUOtpremniciService stavkaUOtpremniciService;
	
	@RequestMapping(
			value = "/getAllOtpremnice",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getAllOtpremnice() {
		List<Otpremnica> otpremnice = otpremnicaService.findAll();
		List<OtpremnicaDTO> otpremniceDTO = otpremnicaConverter.convert(otpremnice);
			return new ResponseEntity<>(otpremniceDTO,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(
			value = "/kreirajOtpremnicu/{idFakture}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> kreirajOtpremnicu(@PathVariable Long idFakture) {
		
		Faktura faktura = fakturaService.findById(idFakture);
		faktura.setOtpremljena(true);
		fakturaService.save(faktura);
		
		
		Otpremnica otpremnica = new Otpremnica();
		
		otpremnica.setDatumOtpremnice(new Date());
		
		 
		
		otpremnica.setBrojOtpremnice(faktura.getBrojFakture());
		otpremnica.setFiskalnaGodina(faktura.getFiskalnaGodina());
		otpremnica.setKompanija(faktura.getKompanija());
		otpremnica.setNacinPlacanja(faktura.getNacinPlacanja());
		otpremnica.setPoslovniPartner(faktura.getPoslovniPartner());
		
		if(faktura.getNacinPlacanja().getNazivTipaPlacanja().equals("racun")){
			otpremnica.setPozivNaBroj(faktura.getPozivNaBroj());
			otpremnica.setRacunZaUplatu(faktura.getRacunZaUplatu());
		}
		
		
		otpremnica.setUkupanPDV(faktura.getUkupanPDV());
		otpremnica.setUkupnaCena(faktura.getUkupnaCena());
		otpremnica.setUkupnaCenaBezPDVa(faktura.getUkupnaCenaBezPDVa());
		otpremnica.setDatumValute(faktura.getDatumValute());
		
		otpremnicaService.save(otpremnica);
	
		for(StavkaUFakturi stavkaUFakturi : faktura.getStavke()){
			StavkaUOtpremnici stavkaUOtpremnici = new StavkaUOtpremnici();
			stavkaUOtpremnici.setArtikal(stavkaUFakturi.getArtikal());
			stavkaUOtpremnici.setOtpremnica(otpremnica);
			stavkaUOtpremnici.setIznosPDVa(stavkaUFakturi.getIznosPDVa());
			stavkaUOtpremnici.setJedinicnaCena(stavkaUFakturi.getJedinicnaCena());
			stavkaUOtpremnici.setJedinicnaCenaBezPDVa(stavkaUFakturi.getJedinicnaCenaSaPDVa());
			stavkaUOtpremnici.setOsnovica(stavkaUFakturi.getOsnovica());
			stavkaUOtpremnici.setPopust(stavkaUFakturi.getPopust());
			stavkaUOtpremnici.setStopaPDVa(stavkaUFakturi.getStopaPDVa());
			stavkaUOtpremnici.setUkupnaKolicina(stavkaUFakturi.getUkupnaKolicina());
			stavkaUOtpremniciService.save(stavkaUOtpremnici);
			
		}
		
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	@RequestMapping(
			value = "/obrisiOtpremnicu/{idOtpremnice}",
			method = RequestMethod.DELETE
	)
	public ResponseEntity<?> obrisiOtpremnicu(@PathVariable Long idOtpremnice) {
		otpremnicaService.delete(idOtpremnice);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(
			value = "/eksportujOtpremnicu/{idOtpremnice}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> eksportujOtpremnicu(@PathVariable Long idOtpremnice) {
		Otpremnica toEksport = otpremnicaService.findById(idOtpremnice);
		OtpremnicaDTO toEksportDTO = otpremnicaConverter.convert(toEksport);
		File file = new File("fileOtpremnica"+idOtpremnice+".xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(OtpremnicaDTO.class);
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
	
	
	
}
