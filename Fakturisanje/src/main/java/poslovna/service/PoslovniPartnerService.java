package poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.PoslovniPartner;
import poslovna.repository.PoslovniPartnerRepository;

@Service
public class PoslovniPartnerService {
	
	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;
	
	public List<PoslovniPartner> findByKompanija(Long idKompanije) {
		return poslovniPartnerRepository.findByKompanijaId(idKompanije);
	}
	
	public PoslovniPartner findById(Long id) {
		return poslovniPartnerRepository.findOne(id);
	}
	
	public List<PoslovniPartner> findByKompanijaAndTip(Long idKompanije, String tip) {
		return poslovniPartnerRepository.findByKompanijaIdAndTipPoslovnogPartneraNaziv(idKompanije, tip);
	}

}
