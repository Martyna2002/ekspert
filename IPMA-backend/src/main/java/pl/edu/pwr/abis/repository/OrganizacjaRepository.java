package pl.edu.pwr.abis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.abis.domain.entities.Organizacja;

public interface OrganizacjaRepository extends JpaRepository<Organizacja, Long> {
}

