package cengiz.data.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class KullaniciRolDto implements Serializable {

    private Integer id;
    private Integer fkKullaniciId;
    private Integer fkRolId;

}
