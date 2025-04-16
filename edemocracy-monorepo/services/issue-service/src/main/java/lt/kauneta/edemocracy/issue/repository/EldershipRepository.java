package lt.kauneta.edemocracy.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.kauneta.edemocracy.issue.models.locations.Eldership;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EldershipRepository extends JpaRepository<Eldership, UUID> {
	Optional<Eldership> findByCode(String code);
    List<Eldership> findByMunicipalityCode(String municipalityCode);
}
