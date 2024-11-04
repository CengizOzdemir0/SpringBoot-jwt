package cengiz.data.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "yetki", schema = "base")
public class Yetki implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('demo.yetki_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "ad", nullable = false, length = Integer.MAX_VALUE)
    private String ad;

    @NotNull
    @Column(name = "soyad", nullable = false, length = Integer.MAX_VALUE)
    private String aciklama;


}
