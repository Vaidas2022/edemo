package lt.kauneta.edemocracy.issue.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IssueRelevanceRepository extends JpaRepository<IssueRelevance, UUID> {
    Optional<IssueRelevance> findByUserIdAndIssueId(UUID userId, UUID issueId);
}
