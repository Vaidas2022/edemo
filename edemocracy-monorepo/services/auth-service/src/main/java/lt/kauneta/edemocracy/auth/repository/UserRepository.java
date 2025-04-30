package lt.kauneta.edemocracy.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.kauneta.edemocracy.auth.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByLoginName(String loginName);
}
