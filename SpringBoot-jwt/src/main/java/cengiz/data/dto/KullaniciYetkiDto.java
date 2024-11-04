package cengiz.data.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class KullaniciYetkiDto implements Serializable {

    private Integer id;
    private Integer fkKullaniciId;
    private Integer fkYetkiId;

}
