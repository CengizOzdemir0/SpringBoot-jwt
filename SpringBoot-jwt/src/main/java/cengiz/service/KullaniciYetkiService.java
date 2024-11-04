package cengiz.service;


import cengiz.data.dto.KullaniciDto;
import cengiz.data.dto.KullaniciYetkiDto;
import cengiz.data.entity.Kullanici;
import cengiz.data.entity.KullaniciYetki;
import cengiz.data.entity.Yetki;
import cengiz.data.mapper.KullaniciMapper;
import cengiz.data.mapper.KullaniciYetkiMapper;
import cengiz.repository.KullaniciYetkiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KullaniciYetkiService {

    private final KullaniciYetkiRepository kullaniciYetkiRepository;
    private final KullaniciYetkiMapper kullaniciYetkiMapper;
    private final KullaniciService kullaniciService;
    private final YetkiService yetkiService;


    public KullaniciYetkiDto save(KullaniciYetkiDto kullaniciYetkiDto) {
        Optional<KullaniciYetki> kullaniciYetki = kullaniciYetkiRepository.findByFkKullaniciIdAndAndFkYetkiId(kullaniciYetkiDto.getFkKullaniciId(), kullaniciYetkiDto.getFkYetkiId());
        if(kullaniciYetki.isPresent()) {
            throw new RuntimeException("Kullanici Yetki iliskisi mevcut");
        }
        KullaniciDto kullaniciById = kullaniciService.getKullaniciById(kullaniciYetkiDto.getFkKullaniciId());
        if(kullaniciById == null) {
            throw new RuntimeException("Kullanici kayitli degil");
        }
        Optional<Yetki> byYetki = yetkiService.findById(kullaniciYetkiDto.getFkYetkiId());
        if(!byYetki.isPresent()) {
            throw new RuntimeException("Yetki tanimli degil");
        }

        return kullaniciYetkiMapper.toDto(kullaniciYetkiRepository.save(kullaniciYetkiMapper.toEntity(kullaniciYetkiDto)));
    }

}
