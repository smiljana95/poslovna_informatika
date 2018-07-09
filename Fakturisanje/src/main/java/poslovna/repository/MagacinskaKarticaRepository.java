package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.MagacinskaKartica;
import poslovna.model.Narudzbenica;

public interface MagacinskaKarticaRepository extends JpaRepository<MagacinskaKartica, Long>{

	MagacinskaKartica findByArtikalIdAndPoslovniPartnerId(Long idArtikla, Long idPP);

}
