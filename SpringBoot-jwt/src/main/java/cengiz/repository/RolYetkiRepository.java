package cengiz.repository;

import cengiz.data.entity.RolYetki;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolYetkiRepository extends JpaRepository<RolYetki, Integer> {

    List<RolYetki> findByFkRolId(Integer rolId);
}
