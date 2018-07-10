package poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.PoslovniPartnerToPoslovniPartnerDTOConverter;
import poslovna.model.PoslovniPartner;
import poslovna.model.Radnik;
import poslovna.service.PoslovniPartnerService;
import poslovna.service.RadnikService;

@RestController
@RequestMapping(value = "/poslovniPartner")
public class PoslovniPartnerController {
	
	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	private RadnikService radnikService;
	
	@Autowired
	private PoslovniPartnerToPoslovniPartnerDTOConverter poslovniPartnerToPoslovniPartnerDTOConverter;
	
	@RequestMapping(
			value = "/getByKompanija/{idKompanije}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByKompanija(@PathVariable Long idKompanije) {
		return new ResponseEntity<>(poslovniPartnerToPoslovniPartnerDTOConverter.convert(poslovniPartnerService.findByKompanija(idKompanije)), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getByUlogovani",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByUlogovani() {
		Radnik ulogovani = radnikService.getCurrentUser();
		if(ulogovani != null) {
			List<PoslovniPartner> dobavljaci = poslovniPartnerService.findByKompanijaAndTip(ulogovani.getKompanija().getId(), "dobavljac");
			dobavljaci.addAll(poslovniPartnerService.findByKompanijaAndTip(ulogovani.getKompanija().getId(), "kupacdobavljac"));
			return new ResponseEntity<>(poslovniPartnerToPoslovniPartnerDTOConverter.convert(dobavljaci), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
