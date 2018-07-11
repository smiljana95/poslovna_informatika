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

	public Faktura save(Faktura faktura) {
		return fakturaRepository.save(faktura);
		
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

	public List<Faktura> findByOtpremljena(boolean b) {
		// TODO Auto-generated method stub
		return fakturaRepository.findByOtpremljena(b);
	}

	public Faktura findByBrojFakture(int brojFakture) {
		// TODO Auto-generated method stub
		return fakturaRepository.findByBrojFakture(brojFakture);
	}

	public List<Faktura> findByOtpremljenaAndPrimljena(boolean b, boolean c) {
		// TODO Auto-generated method stub
		return fakturaRepository.findByOtpremljenaAndPrimljena(b,c);
	}
	
	public List<Faktura> findByOtpremljenaAndPrimljenaAndPoslovniPartnerId(boolean b, boolean c, Long id) {
		// TODO Auto-generated method stub
		return fakturaRepository.findByOtpremljenaAndPrimljenaAndPoslovniPartnerId(b,c,id);
	}
	

}
