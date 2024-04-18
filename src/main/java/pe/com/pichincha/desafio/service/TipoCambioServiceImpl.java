package pe.com.pichincha.desafio.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.pichincha.desafio.entity.Moneda;
import pe.com.pichincha.desafio.entity.TipoCambio;
import pe.com.pichincha.desafio.exception.MyException;
import pe.com.pichincha.desafio.repository.TipoCambioRepository;
import pe.com.pichincha.desafio.web.dto.request.TipoCambioRequest;
import pe.com.pichincha.desafio.web.dto.request.ActualizarTipoCambioRequest;
import pe.com.pichincha.desafio.web.dto.response.ActualizarTipoCambioResponse;
import pe.com.pichincha.desafio.web.dto.response.TipoCambioResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    private TipoCambioRepository repository;

    @Override
    public Mono<TipoCambioResponse> calculateExchangeRate(TipoCambioRequest request) {
        return getAllExchangeRate().map(exchangeRates -> obtenerTipoCambio(exchangeRates, request.getMonedaOrigen(), request.getMonedaDestino())).map(tipoCambio -> {
            // Calcular el monto resultado de manera reactiva
            BigDecimal montoResultado = request.getMonto().multiply(BigDecimal.valueOf(tipoCambio));
            return TipoCambioResponse.builder()
                    .tipoCambio(tipoCambio)
                    .montoResultado(montoResultado)
                    .monedaOrigen(request.getMonedaOrigen())
                    .monedaDestino(request.getMonedaDestino())
                    .build();
        });
    }

    @Override
    public Mono<Long> addExchangeRate(TipoCambioRequest request) {
        return Mono.fromCallable(() -> repository.save(toExchangeRate(request)).getId());
    }

    @Override
    public Mono<List<TipoCambioResponse>> getAllExchangeRate() {
        List<TipoCambioResponse> list = new ArrayList<>();
        repository.findAll().forEach(ex -> list.add(TipoCambioResponse.builder().tipoCambio(ex.getTipoCambio())
                .monedaDestino(ex.getMonedaDestino()).monedaOrigen(ex.getMonedaOrigen()).build()));
        return Mono.just(list);
    }

    public double obtenerTipoCambio(List<TipoCambioResponse> lst, Moneda monedaOrigen, Moneda monedaDestino) {
        return lst.stream().filter(x -> x.getMonedaOrigen().equals(monedaOrigen) && x.getMonedaDestino().equals(monedaDestino))
                .findFirst().map(TipoCambioResponse::getTipoCambio).orElse(0.0);
    }

    private TipoCambio toExchangeRate(TipoCambioRequest tpRq) {
        TipoCambio tipoCambio = new TipoCambio();
        tipoCambio.setMonedaDestino(tpRq.getMonedaDestino());
        tipoCambio.setMonedaOrigen(tpRq.getMonedaOrigen());
        return tipoCambio;
    }

    @Override
    public Mono<ActualizarTipoCambioResponse> updateExchangeRate(Double exchangeRate, ActualizarTipoCambioRequest request) throws MyException {

        Optional<TipoCambio> tipoCambioFound = repository.findByMonedaOrigenAndMonedaDestino(Moneda.valueOf(request.getMonedaOrigen()), Moneda.valueOf(request.getMonedaDestino()));
        if (tipoCambioFound.isPresent()) {
            tipoCambioFound.get().setTipoCambio(exchangeRate);
            repository.save(tipoCambioFound.get());
        } else {
            throw new MyException("No se actualizo el tip de cambio");
        }
        return Mono.just(ActualizarTipoCambioResponse.builder().codigo("0").mensaje("Se actualizo valor del tipo de cambio.").build());
    }

}
