package poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.NacinPlacanjaToNacinPlacanjaDTOConverter;
import poslovna.service.NacinPlacanjaService;

@RestController
@RequestMapping(value = "/nacinPlacanja")
public class NacinPlacanjaController {
	
	@Autowired
	private NacinPlacanjaService nacinPlacanjaService;
	
	@Autowired
	private NacinPlacanjaToNacinPlacanjaDTOConverter nacinPlacanjaToNacinPlacanjaDToConverter;
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(nacinPlacanjaToNacinPlacanjaDToConverter.convert(nacinPlacanjaService.findAll()), HttpStatus.OK);
	}

}
