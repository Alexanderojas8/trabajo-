package cl.edutech.ms_permisos.controller;

import cl.edutech.ms_permisos.model.dto.PermisoRequestDTO;
import cl.edutech.ms_permisos.model.entity.PermisoEntity;
import cl.edutech.ms_permisos.service.PermisoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
@RequiredArgsConstructor
public class PermisoController {

    private final PermisoService permisoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PermisoEntity crear(@Valid @RequestBody PermisoRequestDTO dto) {
        return permisoService.crear(dto);
    }

    @GetMapping
    public List<PermisoEntity> listar() {
        return permisoService.listar();
    }
}