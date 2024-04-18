package pe.com.pichincha.desafio.web.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import pe.com.pichincha.desafio.entity.Moneda;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoCambioResponse {
	private BigDecimal montoResultado;
	private Moneda monedaOrigen;
	private Moneda monedaDestino;
	private Double tipoCambio;
}
