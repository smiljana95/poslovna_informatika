package poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.Artikal;
import poslovna.repository.ArtikalRepository;

@Service
public class ArtikalService {
	
	@Autowired
	private ArtikalRepository artikalRepo;
	
	public List<Artikal> findAll(){
		return artikalRepo.findAll();
	}
	public Artikal findById(Long id){
		return artikalRepo.findOne(id);
	}
}
