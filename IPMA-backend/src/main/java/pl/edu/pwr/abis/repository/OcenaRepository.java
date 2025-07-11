package pl.edu.pwr.abis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.abis.domain.entities.report.Ocena;
import pl.edu.pwr.abis.domain.enums.StatusOcenyKoncowej;
import pl.edu.pwr.abis.domain.enums.TypOceny;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {
    List<Ocena> findByStatusOceny(StatusOcenyKoncowej status);
    List<Ocena> findAllByRodzajAndDataZatwierdzeniaIsNull(TypOceny typ);
}
