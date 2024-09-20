package cengiz.data.projection;

import java.time.LocalDate;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

public interface PersonelBilgileriProjection {

    Integer getPersonelId();
    String getAd();
    String getSoyad();
    Integer getYas();
    String getMeslekKodu();
    String getMeslekAdi();
    LocalDate getMeslekGirisTarihi();

}
