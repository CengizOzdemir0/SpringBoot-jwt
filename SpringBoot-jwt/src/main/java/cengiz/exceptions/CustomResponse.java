package cengiz.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Getter
@Setter
public class CustomResponse<T> {

    private String message;
    private String messageCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public CustomResponse(String message, String messageCode, T data) {
        this.message = message;
        this.messageCode = messageCode;
        this.data = data;
    }

}
