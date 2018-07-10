package poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovna.model.Otpremnica;
import poslovna.repository.OtpremnicaRepository;

@Service
public class OtpremnicaService {
	
	
	@Autowired
	private OtpremnicaRepository otpremnicaRepository;

	public List<Otpremnica> findAll() {
		// TODO Auto-generated method stub
		return otpremnicaRepository.findAll();
	}

	public void save(Otpremnica otpremnica) {
		// TODO Auto-generated method stub
		otpremnicaRepository.save(otpremnica);
		
	}

	public Otpremnica findById(Long idOtpremnice) {
		// TODO Auto-generated method stub
		return otpremnicaRepository.findOne(idOtpremnice);
	}

	public void delete(Long idOtpremnice) {
		// TODO Auto-generated method stub
		otpremnicaRepository.delete(idOtpremnice);
	};
	

}
