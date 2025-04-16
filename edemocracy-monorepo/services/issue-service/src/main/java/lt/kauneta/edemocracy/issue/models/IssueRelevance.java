package lt.kauneta.edemocracy.issue.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "issue_relevance", uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "issueId"}))
public class IssueRelevance {

    @Id
    private UUID id;

    private UUID userId;

    private UUID issueId;

    protected IssueRelevance() {}

    public IssueRelevance(UUID userId, UUID issueId) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.issueId = issueId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getIssueId() {
        return issueId;
    }
}
