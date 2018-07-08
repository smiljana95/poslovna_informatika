package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.Grad;
import poslovna.repository.GradRepository;

@Service
public class GradService {
	
	@Autowired
	private GradRepository gradRepository;
	
	public Grad findById(Long id) {
		return gradRepository.findOne(id);
	}

}
