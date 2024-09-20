package cengiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cengiz.data.entity.PersonelMeslek;
import cengiz.repository.PersonelMeslekRepository;

import java.util.Objects;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Service
@RequiredArgsConstructor
public class PersonelMeslekService {

    private final PersonelMeslekRepository personelMeslekRepository;

    public PersonelMeslek savePersonelMeslek(PersonelMeslek personelMeslek) {
        return personelMeslekRepository.save(personelMeslek);
    }

    public ResponseEntity<PersonelMeslek> getPersonelMeslek(Integer id) {
        PersonelMeslek personelMeslek = personelMeslekRepository.findById(id).orElse(null);
        if (Objects.isNull(personelMeslek)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(personelMeslek);
        }
    }

    public void deletePersonelMeslek(Integer id) {
        personelMeslekRepository.deleteById(id);
    }

    public Page<PersonelMeslek> getAllPersonelMeslek(Pageable pageable) {
        return personelMeslekRepository.findAll(pageable);
    }

    public PersonelMeslek updatePersonelMeslek(Integer id,PersonelMeslek personelMeslek) {
        PersonelMeslek personelMeslek1 = personelMeslekRepository.findById(id).orElseThrow();
        if (personelMeslek1.getPersonel().getId().equals(personelMeslek.getPersonel().getId())) {
            return personelMeslekRepository.save(personelMeslek);
        } else {
            throw new RuntimeException();
        }

    }
}
