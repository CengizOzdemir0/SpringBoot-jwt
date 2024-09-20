package cengiz.data.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Getter
@Setter
public class LoginResponse {

    private String token;

    private long expiresIn;

}
