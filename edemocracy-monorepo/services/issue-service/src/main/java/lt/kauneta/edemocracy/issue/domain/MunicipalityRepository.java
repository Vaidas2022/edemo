package lt.kauneta.edemocracy.issue.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, UUID> {
    Optional<Municipality> findByCode(String code);
    List<Municipality> findByCountyCode(String countyCode);
}

