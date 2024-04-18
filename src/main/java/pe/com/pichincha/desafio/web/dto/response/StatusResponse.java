package pe.com.pichincha.desafio.web.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusResponse implements Serializable {
    private Boolean success;
    private String message;
    private Object data;
    private int code;
    private String status;
}