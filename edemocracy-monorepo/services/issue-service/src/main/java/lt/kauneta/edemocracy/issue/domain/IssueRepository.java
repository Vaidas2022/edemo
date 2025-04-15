package lt.kauneta.edemocracy.issue.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IssueRepository extends JpaRepository<Issue, UUID> {
    List<Issue> findByEldershipIdAndActiveTrue(UUID eldershipId);
}
