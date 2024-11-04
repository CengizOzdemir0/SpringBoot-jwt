package cengiz.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "kullanici_yetki", schema = "base")
public class KullaniciYetki implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('demo.kullanici_yetki_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fk_kullanici_id", nullable = false)
    private Integer fkKullaniciId;
    @Column(name = "fk_yetki_id", nullable = false)
    private Integer fkYetkiId;

}
