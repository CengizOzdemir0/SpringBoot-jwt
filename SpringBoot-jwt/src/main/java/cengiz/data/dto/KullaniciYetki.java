package cengiz.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

public class KullaniciYetki implements GrantedAuthority {

    private String yetki;

    public KullaniciYetki() {
    }

    public KullaniciYetki(String yetki) {
        this.yetki = yetki;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.yetki;
    }

    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
    }
}
