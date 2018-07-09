package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.MagacinskaKartica;
import poslovna.repository.MagacinskaKarticaRepository;

@Service
public class MagacinskaKarticaService {
	
	@Autowired
	private MagacinskaKarticaRepository magacinskaKarticaRepository;

	public MagacinskaKartica findByArtikalIdAndPoslovniPartnerId(Long idArtikla, Long idPP) {
		// TODO Auto-generated method stub
		return magacinskaKarticaRepository.findByArtikalIdAndPoslovniPartnerId(idArtikla,idPP);
	}

}
