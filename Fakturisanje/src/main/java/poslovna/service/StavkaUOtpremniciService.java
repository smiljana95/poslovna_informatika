package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.StavkaUOtpremnici;
import poslovna.repository.StavkaUOtpremniciRepository;

@Service
public class StavkaUOtpremniciService {
	
	@Autowired
	private StavkaUOtpremniciRepository stavkaUOtpremniciRepository;

	public void save(StavkaUOtpremnici stavkaUOtpremnici) {
		// TODO Auto-generated method stub
		stavkaUOtpremniciRepository.save(stavkaUOtpremnici);
	}

}
