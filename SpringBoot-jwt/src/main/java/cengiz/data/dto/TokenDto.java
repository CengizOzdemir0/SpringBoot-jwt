package cengiz.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Getter
@AllArgsConstructor
public class TokenDto {

    private String token;

    private String uuid;

    private String subUuid;
}
