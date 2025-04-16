package lt.kauneta.edemocracy.issue.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.kauneta.edemocracy.issue.models.locations.County;

@Repository
public interface CountyRepository extends JpaRepository<County, UUID> {
    Optional<County> findByCode(String code);
}
