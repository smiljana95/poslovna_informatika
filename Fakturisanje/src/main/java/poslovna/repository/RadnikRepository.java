package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.Radnik;

public interface RadnikRepository extends JpaRepository<Radnik, Long> {
	
	Radnik findByEmailIgnoreCase(String email);

}
