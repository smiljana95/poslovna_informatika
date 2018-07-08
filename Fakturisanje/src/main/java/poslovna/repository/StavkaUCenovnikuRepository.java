package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.Radnik;
import poslovna.model.StavkaUCenovniku;

public interface StavkaUCenovnikuRepository extends JpaRepository<StavkaUCenovniku, Long>  {

}
