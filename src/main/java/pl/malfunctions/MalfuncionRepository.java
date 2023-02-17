package pl.malfunctions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MalfuncionRepository extends JpaRepository<Malfunction, Long> {

}
