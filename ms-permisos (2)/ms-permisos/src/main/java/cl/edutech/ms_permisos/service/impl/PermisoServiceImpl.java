package cl.edutech.ms_permisos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.edutech.ms_permisos.model.dto.PermisoRequestDTO;
import cl.edutech.ms_permisos.model.entity.PermisoEntity;
import cl.edutech.ms_permisos.repository.PermisoRepository;
import cl.edutech.ms_permisos.service.PermisoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermisoServiceImpl implements PermisoService {

    private final PermisoRepository permisoRepository;

    @Override
    public PermisoEntity crear(PermisoRequestDTO dto) {
        permisoRepository.findByNombre(dto.getNombre())
                .ifPresent(p -> { throw new IllegalArgumentException("Ya existe un permiso con ese nombre"); });

        PermisoEntity permiso = PermisoEntity.builder()
                .nombre(dto.getNombre())
                .build();

        return permisoRepository.save(permiso);
    }

    @Override
    public List<PermisoEntity> listar() {
        return permisoRepository.findAll();
    }
}