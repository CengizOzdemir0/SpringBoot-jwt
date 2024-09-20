package cengiz.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Getter
@Setter
public class LoginKullaniciDto implements Serializable {

    private String email;

    private String password;
}
