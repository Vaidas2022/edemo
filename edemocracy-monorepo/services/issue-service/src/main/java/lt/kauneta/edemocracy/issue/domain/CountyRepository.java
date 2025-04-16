package lt.kauneta.edemocracy.issue.domain;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends JpaRepository<County, UUID> {
    Optional<County> findByCode(String code);
}
