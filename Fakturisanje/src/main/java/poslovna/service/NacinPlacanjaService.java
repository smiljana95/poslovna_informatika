package poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.NacinPlacanja;
import poslovna.repository.NacinPlacanjaRepository;

@Service
public class NacinPlacanjaService {
	
	@Autowired
	private NacinPlacanjaRepository nacinPlacanjaRepository;
	
	public NacinPlacanja findOne(Long id) {
		return nacinPlacanjaRepository.findOne(id);
	}
	
	public List<NacinPlacanja> findAll() {
		return nacinPlacanjaRepository.findAll();
	}

}
