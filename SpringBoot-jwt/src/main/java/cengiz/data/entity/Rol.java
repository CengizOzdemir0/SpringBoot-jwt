package cengiz.data.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol", schema = "base")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "adi", nullable = false, length = Integer.MAX_VALUE)
    private String adi;

    @NotNull
    @Column(name = "aciklama", nullable = false, length = Integer.MAX_VALUE)
    private String aciklama;

}
