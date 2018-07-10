package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.MagacinskaKartica;
import poslovna.model.StavkaUFakturi;

public interface StavkaUFakturiRepository extends JpaRepository<StavkaUFakturi, Long>{

}
