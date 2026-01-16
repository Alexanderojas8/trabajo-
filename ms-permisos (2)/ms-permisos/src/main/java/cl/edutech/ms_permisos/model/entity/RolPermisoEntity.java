package cl.edutech.ms_permisos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "rol_permiso",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_rol", "id_permiso"})
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class RolPermisoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_permiso", nullable = false)
    private PermisoEntity permiso;
}