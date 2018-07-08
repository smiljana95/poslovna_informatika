package poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poslovna.model.Grad;

public interface GradRepository extends JpaRepository<Grad, Long> {

}
