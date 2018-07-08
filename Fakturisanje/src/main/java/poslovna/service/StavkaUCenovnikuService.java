package poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.StavkaUCenovniku;
import poslovna.repository.StavkaUCenovnikuRepository;

@Service
public class StavkaUCenovnikuService {

	@Autowired
	private StavkaUCenovnikuRepository stavkaRepository;
	
	public void delete(Long toDelete){
		stavkaRepository.delete(toDelete);
	}
	public StavkaUCenovniku findById(Long id){
		return stavkaRepository.findOne(id);
	}
	public StavkaUCenovniku save(StavkaUCenovniku toSave){
		return stavkaRepository.save(toSave);
	}
}
