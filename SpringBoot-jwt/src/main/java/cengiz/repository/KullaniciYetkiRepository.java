package cengiz.repository;

import cengiz.data.entity.KullaniciYetki;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KullaniciYetkiRepository extends JpaRepository<KullaniciYetki, Long> {

    Optional<KullaniciYetki> findByFkKullaniciIdAndAndFkYetkiId(Integer fkKullaniciId, Integer fkYetkiId);
    List<KullaniciYetki> findAllByFkKullaniciId(Integer fkKullaniciId);


}
