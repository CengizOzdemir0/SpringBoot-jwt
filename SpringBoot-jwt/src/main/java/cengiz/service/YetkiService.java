package cengiz.service;


import cengiz.configuration.redis.RedisService;
import cengiz.data.dto.YetkiDto;
import cengiz.data.entity.Yetki;
import cengiz.data.mapper.YetkiMapper;
import cengiz.repository.YetkiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class YetkiService {

    private final YetkiRepository yetkiRepository;
    private final YetkiMapper yetkiMapper;
    private final RedisService redisService;

    public YetkiDto save(YetkiDto yetkiDto) {
        Optional<Yetki> byAd = yetkiRepository.findByAdi(yetkiDto.getAdi());
        if(byAd.isPresent()) {
            throw new RuntimeException("Yetki kayitli !");
        }

        YetkiDto yetki = yetkiMapper.toDto(yetkiRepository.save(yetkiMapper.toEntity(yetkiDto)));
        redisService.saveValue(String.valueOf(yetki.getId()),yetki);
        return yetki;
    }

    @Cacheable(value = "yetki", key = "#id")
    public Optional<Yetki> findById(Integer id) {
        return yetkiRepository.findById(Long.valueOf(id));
    }


}
