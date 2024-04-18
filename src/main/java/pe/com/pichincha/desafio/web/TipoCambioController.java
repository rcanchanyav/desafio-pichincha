package pe.com.pichincha.desafio.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.com.pichincha.desafio.exception.MyException;
import pe.com.pichincha.desafio.service.TipoCambioService;
import pe.com.pichincha.desafio.web.dto.request.TipoCambioRequest;
import pe.com.pichincha.desafio.web.dto.request.ActualizarTipoCambioRequest;
import pe.com.pichincha.desafio.web.dto.response.ActualizarTipoCambioResponse;
import pe.com.pichincha.desafio.web.dto.response.TipoCambioResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Transactional
@RequestMapping("/api/tipo-cambio")
@RestController
@Tag(name = "UserRs Manager", description = "Operations related to Exchange Rate")
public class TipoCambioController {

    @Autowired
    private TipoCambioService service;

    @Operation(summary = "Calculate ExchangeRate", description = "calculate exchange rate", method = "POST")
    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<TipoCambioResponse>> calcular(@RequestBody TipoCambioRequest request) {
        log.info("Calcular Tipo Cambio");
        return service.calculateExchangeRate(request).map(ResponseEntity::ofNullable);
    }

    @Operation(summary = "Update ExchangeRate", description = "update exchange rate", method = "PUT")
    @PutMapping(value = "/update/{exchangeRate}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<ActualizarTipoCambioResponse>> actualizarTipoCambio(@PathVariable("exchangeRate") Double exchangeRate, @RequestBody ActualizarTipoCambioRequest updateRq) throws MyException {
        log.info("Actualizar Tipo Cambio");
        return service.updateExchangeRate(exchangeRate, updateRq).map(ResponseEntity::ofNullable);
    }

    @Operation(summary = "Get all ExchangeRate", description = "get all exchange rate", method = "GET")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<TipoCambioResponse>>> obtenerLista() {
        log.info("Devolver Lista");
        return service.getAllExchangeRate().map(ResponseEntity::ofNullable);
    }
}
