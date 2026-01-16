package cl.edutech.ms_permisos.service;

import java.util.List;

import cl.edutech.ms_permisos.model.dto.RolRequestDTO;
import cl.edutech.ms_permisos.model.entity.PermisoEntity;
import cl.edutech.ms_permisos.model.entity.RolEntity;

public interface RolService {
    RolEntity crear(RolRequestDTO dto);
    List<RolEntity> listar();

    void asignarPermiso(Integer idRol, Integer idPermiso);
    void quitarPermiso(Integer idRol, Integer idPermiso);
    List<PermisoEntity> listarPermisosDeRol(Integer idRol);
}