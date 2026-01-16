package cl.edutech.ms_permisos.service;

import java.util.List;

import cl.edutech.ms_permisos.model.dto.PermisoRequestDTO;
import cl.edutech.ms_permisos.model.entity.PermisoEntity;

public interface PermisoService {
    PermisoEntity crear(PermisoRequestDTO dto);
    List<PermisoEntity> listar();
}