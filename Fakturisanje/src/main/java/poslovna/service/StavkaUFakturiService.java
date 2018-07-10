package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.StavkaUFakturi;
import poslovna.repository.StavkaUFakturiRepository;

@Service
public class StavkaUFakturiService {
	
	@Autowired
	private StavkaUFakturiRepository stavkaUFakturiRepository;

	public StavkaUFakturi save(StavkaUFakturi stavkaUFakturi) {
		return stavkaUFakturiRepository.save(stavkaUFakturi);
	}
	

}
