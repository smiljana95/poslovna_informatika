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

	public MagacinskaKartica findByArtikalIdAndKompanijaId(Long id, Long id2) {
		// TODO Auto-generated method stub
		return magacinskaKarticaRepository.findByArtikalIdAndKompanijaId(id, id2);
	}

	public void save(MagacinskaKartica magacinskaKartica) {
		magacinskaKarticaRepository.save(magacinskaKartica);
		
	}

}
