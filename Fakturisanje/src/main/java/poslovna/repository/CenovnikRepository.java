package poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.Cenovnik;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

	List<Cenovnik> findByPoslovniPartnerId(Long id);

	Cenovnik findByPoslovniPartnerIdAndAktivan(Long id, boolean b);

}
