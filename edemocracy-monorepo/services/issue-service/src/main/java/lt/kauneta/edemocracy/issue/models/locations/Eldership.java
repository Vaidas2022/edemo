package lt.kauneta.edemocracy.issue.models.locations;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "elderships")
public class Eldership {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipality_id", nullable = false)
    private Municipality municipality;

    protected Eldership() {}

    public Eldership(UUID id, String code, String name, Municipality municipality) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.municipality = municipality;
    }

    public UUID getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public Municipality getMunicipality() { return municipality; }
}
