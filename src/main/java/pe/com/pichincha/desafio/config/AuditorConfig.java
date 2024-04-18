package pe.com.pichincha.desafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import pe.com.pichincha.desafio.service.audit.AuditorAwareImpl;

@Configuration
public class AuditorConfig {

    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}