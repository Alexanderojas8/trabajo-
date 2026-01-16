package cl.edutech.ms_permisos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.ms_permisos.model.entity.PermisoEntity;

public interface PermisoRepository extends JpaRepository<PermisoEntity, Integer> {
    Optional<PermisoEntity> findByNombre(String nombre);
}