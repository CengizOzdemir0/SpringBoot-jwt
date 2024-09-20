package cengiz.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Getter
@Setter
public class PersonelBilgileriDto {

    private Integer personelId;
    private String ad;
    private String soyad;
    private Integer yas;
    private String meslekKodu;
    private String meslekAdi;
    private LocalDate meslekGirisTarihi;
}
