package pe.com.pichincha.desafio.web.dto.request;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ActualizarTipoCambioRequest {
	private String monedaOrigen;
	private String monedaDestino;
}
