package poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.Cenovnik;
import poslovna.repository.CenovnikRepository;

@Service
public class CenovnikService {

	@Autowired
	private CenovnikRepository cenovnikRepository;
	
	public Cenovnik findByPoslovniPartnerIdAndAktivan(Long id){
		return cenovnikRepository.findByPoslovniPartnerIdAndAktivan(id,true);
	}
}
