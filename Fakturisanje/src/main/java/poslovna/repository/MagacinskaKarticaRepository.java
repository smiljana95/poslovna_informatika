package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.MagacinskaKartica;

public interface MagacinskaKarticaRepository extends JpaRepository<MagacinskaKartica, Long>{

	MagacinskaKartica findByArtikalIdAndPoslovniPartnerId(Long idArtikla, Long idPP);

	MagacinskaKartica findByArtikalIdAndKompanijaId(Long id, Long id2);

}
