package cl.edutech.ms_permisos.service.impl;


import cl.edutech.ms_permisos.model.dto.RolRequestDTO;
import cl.edutech.ms_permisos.model.entity.PermisoEntity;
import cl.edutech.ms_permisos.model.entity.RolEntity;
import cl.edutech.ms_permisos.model.entity.RolPermisoEntity;
import cl.edutech.ms_permisos.repository.PermisoRepository;
import cl.edutech.ms_permisos.repository.RolPermisoRepository;
import cl.edutech.ms_permisos.repository.RolRepository;
import cl.edutech.ms_permisos.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final PermisoRepository permisoRepository;
    private final RolPermisoRepository rolPermisoRepository;

    @Override
    public RolEntity crear(RolRequestDTO dto) {
        rolRepository.findByNombre(dto.getNombre())
                .ifPresent(r -> { throw new IllegalArgumentException("Ya existe un rol con ese nombre"); });

        RolEntity rol = RolEntity.builder()
                .nombre(dto.getNombre())
                .build();

        return rolRepository.save(rol);
    }

    @Override
    public List<RolEntity> listar() {
        return rolRepository.findAll();
    }

    @Override
    public void asignarPermiso(Integer idRol, Integer idPermiso) {
        RolEntity rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        PermisoEntity permiso = permisoRepository.findById(idPermiso)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));

        rolPermisoRepository.findByRol_IdRolAndPermiso_IdPermiso(idRol, idPermiso)
                .ifPresent(x -> { throw new IllegalArgumentException("Ese permiso ya está asignado a ese rol"); });

        RolPermisoEntity rp = RolPermisoEntity.builder()
                .rol(rol)
                .permiso(permiso)
                .build();

        rolPermisoRepository.save(rp);
    }

    @Override
    public void quitarPermiso(Integer idRol, Integer idPermiso) {
        RolPermisoEntity rp = rolPermisoRepository.findByRol_IdRolAndPermiso_IdPermiso(idRol, idPermiso)
                .orElseThrow(() -> new RuntimeException("La asignación rol-permiso no existe"));

        rolPermisoRepository.delete(rp);
    }

    @Override
    public List<PermisoEntity> listarPermisosDeRol(Integer idRol) {
        // valida que exista el rol
        rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        return rolPermisoRepository.findByRol_IdRol(idRol)
                .stream()
                .map(RolPermisoEntity::getPermiso)
                .toList();
    }
}