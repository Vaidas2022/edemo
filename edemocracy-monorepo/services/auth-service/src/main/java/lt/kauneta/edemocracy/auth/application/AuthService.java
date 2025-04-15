package lt.kauneta.edemocracy.auth.application;

import lt.kauneta.edemocracy.auth.domain.User;
import lt.kauneta.edemocracy.auth.dto.LoginRequest;
import lt.kauneta.edemocracy.auth.security.JwtProvider;
import lt.kauneta.edemocracy.auth.domain.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public String authenticate(LoginRequest request) {
        User user = userRepository.findByLoginName(request.loginName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtProvider.generateToken(user.getId(), user.getRole());
    }
}
