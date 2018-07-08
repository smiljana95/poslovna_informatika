package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.TipPoslovnogPartnera;
import poslovna.repository.TipPoslovnogPartneraRepository;

@Service
public class TipPoslovnogPartneraService {
	
	@Autowired
	private TipPoslovnogPartneraRepository tipPoslovnogPartneraRepository;
	
	public TipPoslovnogPartnera findById(Long id) {
		return tipPoslovnogPartneraRepository.findOne(id);
	}

}
