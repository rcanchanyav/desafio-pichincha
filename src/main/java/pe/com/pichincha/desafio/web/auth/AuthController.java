package pe.com.pichincha.desafio.web.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.pichincha.desafio.service.auth.AuthService;
import pe.com.pichincha.desafio.web.dto.request.RegisterRequest;
import pe.com.pichincha.desafio.web.dto.response.AuthResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    /**
     * se debe primero registrar el usuario y luego ya ejecutar  el metodo login
     * */
    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }


    @GetMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok(authService.login(username, password));
    }
}