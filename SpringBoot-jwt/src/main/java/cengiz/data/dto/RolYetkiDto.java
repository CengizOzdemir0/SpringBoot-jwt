package cengiz.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RolYetkiDto implements Serializable {


    private Integer id;
    private Integer fkRolId;
    private Integer fkYetkiId;
}
