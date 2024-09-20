package cengiz.data.dto;

import lombok.Getter;
import lombok.Setter;
import cengiz.data.entity.Personel;

import java.time.LocalDate;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Getter
@Setter
public class UnvanDto {

    private Integer id;
    private String unvanKodu;
    private String unvanAdi;
    private LocalDate unvanVerilisTarihi;
    private LocalDate unvanGuncellenmeTarihi;
    private Personel unvanGuncelleyenPersonelId;

}
