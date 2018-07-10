package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.Faktura;

public interface FakturaRepository extends JpaRepository<Faktura, Long> {

}
