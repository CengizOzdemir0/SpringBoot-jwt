package cengiz.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol_yetki", schema = "base")
public class RolYetki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "fk_rol_id", nullable = false)
    private Integer fkRolId;

    @Column(name = "fk_yetki_id", nullable = false)
    private Integer fkYetkiId;

}
