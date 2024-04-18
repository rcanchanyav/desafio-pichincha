package pe.com.pichincha.desafio.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.pichincha.desafio.Jwt.JwtService;
import pe.com.pichincha.desafio.entity.auth.Role;
import pe.com.pichincha.desafio.entity.auth.User;
import pe.com.pichincha.desafio.repository.UserRepository;
import pe.com.pichincha.desafio.web.dto.request.RegisterRequest;
import pe.com.pichincha.desafio.web.dto.response.AuthResponse;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        UserDetails user = userRepository.findByUsername(username).orElseThrow();
        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER).build();
        userRepository.save(user);
        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }

}
