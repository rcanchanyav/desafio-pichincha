package pe.com.pichincha.desafio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.pichincha.desafio.entity.Moneda;
import pe.com.pichincha.desafio.entity.TipoCambio;

import java.util.Optional;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, String> {

    Optional<TipoCambio> findByMonedaOrigenAndMonedaDestino(Moneda monedaOrigen, Moneda monedaDestino);

} 