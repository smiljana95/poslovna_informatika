package poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.Narudzbenica;
import poslovna.repository.NarudzbenicaRepository;

@Service
public class NarudzbenicaService {

	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
	public List<Narudzbenica> findByPoslovniPartnerIdAndKompanijaID(Long idPP, Long idKompanije) {
		// TODO Auto-generated method stub
		return narudzbenicaRepository.findByPoslovniPartnerIdAndKompanijaId(idPP,idKompanije);
	}

	public Narudzbenica findById(Long idNarudzbenice) {
		// TODO Auto-generated method stub
		return narudzbenicaRepository.findOne(idNarudzbenice);
	}
	
	public Narudzbenica save(Narudzbenica narudzbenica) {
		return narudzbenicaRepository.save(narudzbenica);
	}
	
	public void delete(Long id) {
		narudzbenicaRepository.delete(id);
	}

	public Narudzbenica findByBrojNarudzbenice(int brojNarudzbenice) {
		// TODO Auto-generated method stub
		return narudzbenicaRepository.findByBrojNarudzbenice(brojNarudzbenice);
	}

	public List<Narudzbenica> findByPoslovniPartnerIdAndKompanijaIDAndOdKupca(Long idPP, Long idKompanije, boolean b) {
		// TODO Auto-generated method stub
		return narudzbenicaRepository.findByPoslovniPartnerIdAndKompanijaIdAndOdKupca(idPP, idKompanije, b);
	}

	public List<Narudzbenica> findByPoslovniPartnerIdAndKompanijaIDAndOdKupcaAndPoslata(Long idPP, Long idKompanije,
			boolean b, boolean c) {
		// TODO Auto-generated method stub
		return narudzbenicaRepository.findByPoslovniPartnerIdAndKompanijaIdAndOdKupcaAndPoslata(idPP, idKompanije, b, c);
	}

}
