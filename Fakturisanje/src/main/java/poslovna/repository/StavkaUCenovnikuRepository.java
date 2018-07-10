package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.StavkaUCenovniku;

public interface StavkaUCenovnikuRepository extends JpaRepository<StavkaUCenovniku, Long>  {

	StavkaUCenovniku findByArtikalIdAndCenovnikId(Long idArtikla, Long idCenovnika);

}
