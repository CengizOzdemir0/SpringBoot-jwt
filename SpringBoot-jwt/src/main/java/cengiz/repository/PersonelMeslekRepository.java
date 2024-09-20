package cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cengiz.data.entity.PersonelMeslek;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

public interface PersonelMeslekRepository extends JpaRepository<PersonelMeslek,Integer> {
}
