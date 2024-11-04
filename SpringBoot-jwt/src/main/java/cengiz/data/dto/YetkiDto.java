package cengiz.data.dto;



import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
public class YetkiDto implements Serializable {


    private Integer id;
    private String ad;
    private String aciklama;
}
