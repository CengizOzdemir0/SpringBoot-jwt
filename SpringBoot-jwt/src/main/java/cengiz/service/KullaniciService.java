package cengiz.service;

import cengiz.data.dto.KullaniciDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cengiz.data.entity.Kullanici;
import cengiz.data.mapper.KullaniciMapper;
import cengiz.repository.KullaniciRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Service
@RequiredArgsConstructor
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;
    private final KullaniciMapper kullaniciMapper;

    public KullaniciDto createKullanici(KullaniciDto kullaniciDto) {
        Optional<Kullanici> byEmail = kullaniciRepository.findByEmail(kullaniciDto.getEmail());
        if(byEmail.isPresent()) {
            throw new RuntimeException("Kullanici mevcut");

        }
        kullaniciDto.setUuid(UUID.randomUUID());
        Kullanici kullanici = kullaniciMapper.toEntity(kullaniciDto);
        kullanici = kullaniciRepository.save(kullanici);
        return kullaniciMapper.toDto(kullanici);
    }


    @Cacheable(value = "kullanici", key = "#id")
    public KullaniciDto getKullaniciById(Integer id) {
        Kullanici kullanici = kullaniciRepository.findById(id).orElse(null);
        return kullaniciMapper.toDto(kullanici);
    }

    public KullaniciDto getKullaniciByEmail(String email) {
       return kullaniciMapper.toDto(kullaniciRepository.findByEmail(email).orElse(null));
    }


    public Page<KullaniciDto> getAllKullanici(Pageable pageable) {
        return kullaniciRepository.findAll(pageable).map(kullaniciMapper::toDto);
    }

    public KullaniciDto updatePersonel(Integer id, KullaniciDto kullaniciDto) {
        Kullanici kullanici = kullaniciRepository.findById(id).orElseThrow();
        Kullanici kullanici1 = kullaniciMapper.toEntity(kullaniciDto);
        if (kullanici.getId().equals(kullaniciDto.getId())) {
            Kullanici kullanici2 = kullaniciRepository.save(kullanici1);
            return kullaniciMapper.toDto(kullanici2);
        } else {
            throw new RuntimeException();
        }

    }

    public void deleteKullanici(Integer id) {
        kullaniciRepository.deleteById(id);
    }


    public List<Kullanici> allUsers() {
        List<Kullanici> kullanicilar = new ArrayList<>();

        kullaniciRepository.findAll().forEach(kullanicilar::add);

        return kullanicilar;
    }
}
