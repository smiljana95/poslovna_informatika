package poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.Faktura;
import poslovna.repository.FakturaRepository;

@Service
public class FakturaService {
	
	@Autowired
	private FakturaRepository fakturaRepository;

	public void save(Faktura faktura) {
		fakturaRepository.save(faktura);
		
	}

	public List<Faktura> findAll() {
		// TODO Auto-generated method stub
		return fakturaRepository.findAll();
	}

	public void delete(Long idFakture) {
		// TODO Auto-generated method stub
		 fakturaRepository.delete(idFakture);
	}

	public Faktura findById(Long idFakture) {
		// TODO Auto-generated method stub
		return fakturaRepository.findOne(idFakture);
	}
	

}
