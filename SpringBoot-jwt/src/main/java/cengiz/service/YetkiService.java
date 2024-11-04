package cengiz.service;


import cengiz.configuration.redis.RedisService;
import cengiz.data.dto.YetkiDto;
import cengiz.data.entity.KullaniciYetki;
import cengiz.data.entity.Yetki;
import cengiz.data.mapper.YetkiMapper;
import cengiz.repository.YetkiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class YetkiService {

    private final YetkiRepository yetkiRepository;
    private final YetkiMapper yetkiMapper;
    private final RedisService redisService;
    private final KullaniciYetkiService kullaniciYetkiService;

    public YetkiService(YetkiRepository yetkiRepository, YetkiMapper yetkiMapper, RedisService redisService, @Lazy KullaniciYetkiService kullaniciYetkiService) {
        this.yetkiRepository = yetkiRepository;
        this.yetkiMapper = yetkiMapper;
        this.redisService = redisService;
        this.kullaniciYetkiService = kullaniciYetkiService;
    }


    public YetkiDto save(YetkiDto yetkiDto) {
        Optional<Yetki> byAd = yetkiRepository.findByAdi(yetkiDto.getAdi());
        if (byAd.isPresent()) {
            throw new RuntimeException("Yetki kayitli !");
        }

        YetkiDto yetki = yetkiMapper.toDto(yetkiRepository.save(yetkiMapper.toEntity(yetkiDto)));
        redisService.saveValue(String.valueOf(yetki.getId()), yetki);
        return yetki;
    }

    @Cacheable(value = "yetki", key = "#id")
    public Optional<Yetki> findById(Integer id) {
        return yetkiRepository.findById(Long.valueOf(id));
    }


    public Yetki findByYetki(Integer yetkiId) {
        return yetkiRepository.findById(yetkiId);
    }

    public List<Yetki> findAllkullaniciYetkiList(Integer fkKullaniciId) {
        List<KullaniciYetki> allKullaniciYetkiList = kullaniciYetkiService.findAllKullaniciYetkiList(fkKullaniciId);
        List<Yetki> yetkiDtos = new ArrayList<>();
        allKullaniciYetkiList.forEach(item -> yetkiDtos.add(findByYetki(item.getFkYetkiId())));
        return yetkiDtos;
    }


}
