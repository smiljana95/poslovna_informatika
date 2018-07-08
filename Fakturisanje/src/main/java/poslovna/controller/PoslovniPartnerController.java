package poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.PoslovniPartnerToPoslovniPartnerDTOConverter;
import poslovna.service.PoslovniPartnerService;

@RestController
@RequestMapping(value = "/poslovniPartner")
public class PoslovniPartnerController {
	
	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	private PoslovniPartnerToPoslovniPartnerDTOConverter poslovniPartnerToPoslovniPartnerDTOConverter;
	
	@RequestMapping(
			value = "/getByKompanija/{idKompanije}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByKompanija(@PathVariable Long idKompanije) {
		return new ResponseEntity<>(poslovniPartnerToPoslovniPartnerDTOConverter.convert(poslovniPartnerService.findByKompanija(idKompanije)), HttpStatus.OK);
	}

}
