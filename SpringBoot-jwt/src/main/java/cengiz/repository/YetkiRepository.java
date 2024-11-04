package cengiz.repository;

import cengiz.data.entity.Yetki;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YetkiRepository extends JpaRepository<Yetki, Long> {

    Optional<Yetki> findByAdi(String ad);
    Yetki findById(Integer id);

}
