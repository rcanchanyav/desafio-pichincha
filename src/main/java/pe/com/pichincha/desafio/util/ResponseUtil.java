package pe.com.pichincha.desafio.util;

import org.springframework.http.ResponseEntity;
import pe.com.pichincha.desafio.web.dto.response.StatusResponse;

public class ResponseUtil {

    public static ResponseEntity<StatusResponse> buildResponseEntity(StatusResponse response) {
        ResponseEntity.ofNullable(response);
        if (response.getSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.internalServerError().body(response);
    }
}
