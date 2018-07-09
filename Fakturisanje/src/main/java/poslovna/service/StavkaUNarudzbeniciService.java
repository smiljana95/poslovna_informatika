package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.StavkaUNarudzbenici;
import poslovna.repository.StavkaUNarudzbeniciRepository;

@Service
public class StavkaUNarudzbeniciService {
	
	@Autowired
	private StavkaUNarudzbeniciRepository stavkaUNarudzbeniciRepository;
	
	public StavkaUNarudzbenici save(StavkaUNarudzbenici stavka) {
		return stavkaUNarudzbeniciRepository.save(stavka);
	}

}
