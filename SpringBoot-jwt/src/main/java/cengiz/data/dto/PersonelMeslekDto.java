package cengiz.data.dto;

import cengiz.data.entity.Personel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Getter
@Setter
public class PersonelMeslekDto {

    private Integer id;
    private Personel personel;
    private String meslekKodu;
    private String meslekAdi;
    private LocalDate meslekGirisTarihi;
}
