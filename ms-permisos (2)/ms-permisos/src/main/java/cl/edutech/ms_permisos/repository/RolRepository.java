package cl.edutech.ms_permisos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edutech.ms_permisos.model.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Integer> {
    Optional<RolEntity> findByNombre(String nombre);
}