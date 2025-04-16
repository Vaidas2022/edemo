package lt.kauneta.edemocracy.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.kauneta.edemocracy.issue.models.Issue;

import java.util.List;
import java.util.UUID;

public interface IssueRepository extends JpaRepository<Issue, UUID> {
    List<Issue> findByEldershipIdAndActiveTrue(UUID eldershipId);
}
