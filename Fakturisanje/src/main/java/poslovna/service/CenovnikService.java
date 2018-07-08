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
	public List<Cenovnik> findByKompanija(Long idKompanije) {
		return cenovnikRepository.findByKompanijaId(idKompanije);
	}
	public Cenovnik findById(Long id){
		return cenovnikRepository.findOne(id);
	}
	public Cenovnik save(Cenovnik toSave){
		return cenovnikRepository.save(toSave);
	}
}
