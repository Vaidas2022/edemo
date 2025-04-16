package lt.kauneta.edemocracy.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.kauneta.edemocracy.issue.models.IssueRelevance;

import java.util.Optional;
import java.util.UUID;

public interface IssueRelevanceRepository extends JpaRepository<IssueRelevance, UUID> {
    Optional<IssueRelevance> findByUserIdAndIssueId(UUID userId, UUID issueId);
}
