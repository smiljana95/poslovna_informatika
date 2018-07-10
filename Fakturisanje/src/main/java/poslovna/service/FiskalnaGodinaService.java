package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.FiskalnaGodina;
import poslovna.repository.FiskalnaGodinaRepository;

@Service
public class FiskalnaGodinaService {
	
	@Autowired
	private FiskalnaGodinaRepository fiskalnaGodinaRepository;
	
	public FiskalnaGodina findByKompanijaAndAktivna(Long idKompanije) {
		return fiskalnaGodinaRepository.findByKompanijaIdAndAktivna(idKompanije, true);
	}

}
