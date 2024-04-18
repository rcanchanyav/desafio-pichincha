package pe.com.pichincha.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.pichincha.desafio.entity.auth.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username); 
}
