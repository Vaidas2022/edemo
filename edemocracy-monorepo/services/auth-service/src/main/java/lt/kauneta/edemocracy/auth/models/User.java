package lt.kauneta.edemocracy.auth.models;

import jakarta.persistence.*;
import lt.kauneta.edemocracy.issue.models.locations.Eldership;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String loginName;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String role;
    
    @ManyToOne
    @JoinColumn(name = "eldership_id")
    private Eldership eldership;

    protected User() {
    }

    public User(String loginName, String passwordHash, String role) {
        this.id = UUID.randomUUID();
        this.loginName = loginName;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getRole() {
        return role;
    }

	public void setEldership(Eldership eldership) {
		this.eldership = eldership;
		
	}
}
