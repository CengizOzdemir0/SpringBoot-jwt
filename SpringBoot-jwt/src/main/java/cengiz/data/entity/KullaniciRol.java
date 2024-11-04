package cengiz.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "kullanici_rol", schema = "base")
public class KullaniciRol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('demo.kullanici_rol_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fk_kullanici_id", nullable = false)
    private Integer fkKullaniciId;
    @Column(name = "fk_rol_id", nullable = false)
    private Integer fkRolId;

}
