package poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.PoslovniPartner;

public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner, Long> {
	
	List<PoslovniPartner> findByKompanijaId(Long idKompanije);

}
