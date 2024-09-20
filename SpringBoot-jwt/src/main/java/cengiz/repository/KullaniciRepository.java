package cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cengiz.data.entity.Kullanici;

import java.util.Optional;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {
    Optional<Kullanici> findByEmail(String email);
}
