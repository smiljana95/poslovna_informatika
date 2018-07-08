package poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.CenovnikToCenovnikDTOConverter;
import poslovna.model.Cenovnik;
import poslovna.service.CenovnikService;

@RestController
@RequestMapping(value = "/cenovnik")
public class CenovnikController {
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@Autowired
	private CenovnikToCenovnikDTOConverter cenovnikToCenovnikDTOConverter;
	
	@RequestMapping(
			value = "/getByPP/{idPP}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getByPP(@PathVariable Long idPP) {
		Cenovnik aktuelni = cenovnikService.findByPoslovniPartnerIdAndAktivan(idPP);
		
		return new ResponseEntity<>(cenovnikToCenovnikDTOConverter.convert(aktuelni), HttpStatus.OK);
	}

}
