package lt.kauneta.edemocracy.auth.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contact_info")
public class ContactInfo {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String email;

    private String altEmail;
    private String phone;

    protected ContactInfo() {}

    public ContactInfo(UUID userId, String email, String altEmail, String phone) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.email = email;
        this.altEmail = altEmail;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public String getPhone() {
        return phone;
    }
}
