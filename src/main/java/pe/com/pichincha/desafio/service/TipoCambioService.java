package pe.com.pichincha.desafio.service;

import pe.com.pichincha.desafio.exception.MyException;
import pe.com.pichincha.desafio.web.dto.request.ActualizarTipoCambioRequest;
import pe.com.pichincha.desafio.web.dto.request.TipoCambioRequest;
import pe.com.pichincha.desafio.web.dto.response.ActualizarTipoCambioResponse;
import pe.com.pichincha.desafio.web.dto.response.TipoCambioResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TipoCambioService {

    Mono<Long> addExchangeRate(TipoCambioRequest request);

    Mono<ActualizarTipoCambioResponse> updateExchangeRate(Double exchangeRate, ActualizarTipoCambioRequest request) throws MyException;

    Mono<TipoCambioResponse> calculateExchangeRate(TipoCambioRequest request);

    Mono<List<TipoCambioResponse>> getAllExchangeRate();
}
