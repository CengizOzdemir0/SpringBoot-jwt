package cengiz.repository;

import cengiz.data.entity.KullaniciRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KullaniciRolRepository extends JpaRepository<KullaniciRol, Long> {

    Optional<KullaniciRol> findByFkKullaniciIdAndAndFkRolId(Integer fkKullaniciId, Integer fkRolId);
    List<KullaniciRol> findAllByFkKullaniciId(Integer fkKullaniciId);


}
