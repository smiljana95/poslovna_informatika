package poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.converter.NarudzbenicaToNarudzbenicaDTOConverter;
import poslovna.model.Narudzbenica;
import poslovna.service.NarudzbenicaService;
import poslovna.service.RadnikService;

@RestController
@RequestMapping(value = "/narudzbenica")
public class NarudzbenicaController {
	
	@Autowired
	private  NarudzbenicaService narudzbenicaService;
	
	@Autowired
	private RadnikService radnikService;
	
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

}
