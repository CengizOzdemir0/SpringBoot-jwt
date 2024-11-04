package cengiz.service;


import cengiz.data.dto.KullaniciDto;
import cengiz.data.dto.KullaniciRolDto;
import cengiz.data.entity.KullaniciRol;
import cengiz.data.entity.Rol;
import cengiz.data.entity.Yetki;
import cengiz.data.mapper.KullaniciRolMapper;
import cengiz.repository.KullaniciRolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciRolService {

    private final KullaniciRolRepository kullaniciRolRepository;
    private final KullaniciRolMapper kullaniciRolMapper;
    private final KullaniciService kullaniciService;
    private final RolService rolService;

    public KullaniciRolService(KullaniciRolRepository kullaniciRolRepository, KullaniciRolMapper kullaniciYetkiMapper, KullaniciService kullaniciService, RolService rolService) {
        this.kullaniciRolRepository = kullaniciRolRepository;
        this.kullaniciRolMapper = kullaniciYetkiMapper;
        this.kullaniciService = kullaniciService;
        this.rolService = rolService;
    }


    public KullaniciRolDto save(KullaniciRolDto kullaniciYetkiDto) {
        Optional<KullaniciRol> kullaniciYetki = kullaniciRolRepository.findByFkKullaniciIdAndAndFkRolId(kullaniciYetkiDto.getFkKullaniciId(), kullaniciYetkiDto.getFkRolId());
        if(kullaniciYetki.isPresent()) {
            throw new RuntimeException("Kullanici Yetki iliskisi mevcut");
        }
        KullaniciDto kullaniciById = kullaniciService.getKullaniciById(kullaniciYetkiDto.getFkKullaniciId());
        if(kullaniciById == null) {
            throw new RuntimeException("Kullanici kayitli degil");
        }
        Optional<Rol> byId = rolService.findById(kullaniciYetkiDto.getFkRolId());
        if(byId.isEmpty()) {
            throw new RuntimeException("Rol tanimli degil");
        }

        return kullaniciRolMapper.toDto(kullaniciRolRepository.save(kullaniciRolMapper.toEntity(kullaniciYetkiDto)));
    }

    public List<KullaniciRol> findAllKullaniciYetkiList(Integer fkKullaniciId) {
      return kullaniciRolRepository.findAllByFkKullaniciId(fkKullaniciId);
    }



}
