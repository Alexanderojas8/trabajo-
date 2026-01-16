package cl.edutech.ms_permisos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.ms_permisos.model.entity.RolPermisoEntity;

public interface RolPermisoRepository extends JpaRepository<RolPermisoEntity, Integer> {

    Optional<RolPermisoEntity> findByRol_IdRolAndPermiso_IdPermiso(Integer idRol, Integer idPermiso);

    List<RolPermisoEntity> findByRol_IdRol(Integer idRol);
}