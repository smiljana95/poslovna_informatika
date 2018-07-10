package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.FiskalnaGodina;

public interface FiskalnaGodinaRepository extends JpaRepository<FiskalnaGodina, Long> {
	
	FiskalnaGodina findByKompanijaIdAndAktivna(Long idKompanije, boolean aktivna);

}
