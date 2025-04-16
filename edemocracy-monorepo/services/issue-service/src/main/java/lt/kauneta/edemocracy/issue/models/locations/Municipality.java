package lt.kauneta.edemocracy.issue.models.locations;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "municipalities")
public class Municipality {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @OneToMany(mappedBy = "municipality", cascade = CascadeType.ALL)
    private List<Eldership> elderships;

    protected Municipality() {}

    public Municipality(UUID id, String code, String name, County county) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.county = county;
    }

    public UUID getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public County getCounty() { return county; }
}
