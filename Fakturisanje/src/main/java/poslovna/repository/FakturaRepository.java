package poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.Faktura;

public interface FakturaRepository extends JpaRepository<Faktura, Long> {

	List<Faktura> findByOtpremljena(boolean b);

}
