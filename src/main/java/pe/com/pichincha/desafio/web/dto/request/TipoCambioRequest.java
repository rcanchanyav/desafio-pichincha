package pe.com.pichincha.desafio.web.dto.request;


import lombok.Builder;
import lombok.Data;
import pe.com.pichincha.desafio.entity.Moneda;

import java.math.BigDecimal;

@Data
@Builder
public class TipoCambioRequest {
	private BigDecimal monto;
	private Moneda monedaOrigen;
	private Moneda monedaDestino;
}
