package pe.com.pichincha.desafio.service.audit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Value("${spring.datasource.username}")
    private String dataBaseUser;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(dataBaseUser);
    }
}