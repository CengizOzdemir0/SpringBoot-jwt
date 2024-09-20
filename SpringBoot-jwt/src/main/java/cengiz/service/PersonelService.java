package cengiz.service;

import cengiz.data.dto.PersonelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cengiz.data.entity.Personel;
import cengiz.data.mapper.PersonelMapper;
import cengiz.data.projection.PersonelBilgileriProjection;
import cengiz.repository.PersonelRepository;

import java.util.List;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Service
@RequiredArgsConstructor
public class PersonelService {

    private final PersonelRepository personelRepository;
    private final PersonelMapper personelMapper;

    public PersonelDto createPersonel(PersonelDto personelDto) {
        Personel personel = personelMapper.toEntity(personelDto);
        personel = personelRepository.save(personel);
        return personelMapper.toDto(personel);
    }

    @Cacheable(value = "personel", key = "#id")
    public PersonelDto getPersonelById(Integer id) {
        Personel personel = personelRepository.findById(id).orElse(null);
        return personelMapper.toDto(personel);
    }


    public Page<PersonelDto> getAllPersonels(Pageable pageable) {
        return personelRepository.findAll(pageable).map(personelMapper::toDto);
    }

    public PersonelDto updatePersonel(Integer id, PersonelDto personelDto) {
        Personel personel = personelRepository.findById(id).orElseThrow();
        Personel personel1 = personelMapper.toEntity(personelDto);
        if (personel.getId().equals(personelDto.getId())) {
            Personel personel2 = personelRepository.save(personel1);
            return personelMapper.toDto(personel2);
        } else {
            throw new RuntimeException();
        }

    }

    public void deletePersonel(Integer id) {
        personelRepository.deleteById(id);
    }

    public List<PersonelBilgileriProjection> getPersonelWithMeslekProjection(Integer personelId) {
        return personelRepository.findPersonelWithMeslekBilgileri(personelId);
    }
}
