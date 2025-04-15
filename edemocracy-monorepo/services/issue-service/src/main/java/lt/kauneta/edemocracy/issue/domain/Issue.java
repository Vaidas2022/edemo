package lt.kauneta.edemocracy.issue.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "issues")
public class Issue {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private UUID eldershipId;

    private boolean active;

    protected Issue() {}

    public Issue(String title, String description, UUID eldershipId) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.eldershipId = eldershipId;
        this.active = true;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getEldershipId() {
        return eldershipId;
    }

    public boolean isActive() {
        return active;
    }
}
