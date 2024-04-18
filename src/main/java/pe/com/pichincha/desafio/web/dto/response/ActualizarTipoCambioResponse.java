package pe.com.pichincha.desafio.web.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class ActualizarTipoCambioResponse {
	private String codigo;
	private String mensaje;
}
