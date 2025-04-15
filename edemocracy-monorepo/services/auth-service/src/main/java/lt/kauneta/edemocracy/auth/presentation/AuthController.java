package lt.kauneta.edemocracy.auth.presentation;

import lt.kauneta.edemocracy.auth.application.AuthService;
import lt.kauneta.edemocracy.auth.dto.AuthResponse;
import lt.kauneta.edemocracy.auth.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String token = authService.authenticate(request);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
