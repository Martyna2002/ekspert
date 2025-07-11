package pl.edu.pwr.abis.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.abis.domain.entities.RaportZWizytyStudyjnej;

public interface RaportWizytyRepository extends JpaRepository<RaportZWizytyStudyjnej, Long> {
    List<RaportZWizytyStudyjnej> findAllByOrderByPlanowanaDataOpracowaniaAsc();
}
