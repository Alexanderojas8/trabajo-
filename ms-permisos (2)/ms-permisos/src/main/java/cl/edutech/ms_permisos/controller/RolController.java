package cl.edutech.ms_permisos.controller;

import cl.edutech.ms_permisos.model.dto.RolRequestDTO;
import cl.edutech.ms_permisos.model.entity.PermisoEntity;
import cl.edutech.ms_permisos.model.entity.RolEntity;
import cl.edutech.ms_permisos.service.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RolEntity crear(@Valid @RequestBody RolRequestDTO dto) {
        return rolService.crear(dto);
    }

    @GetMapping
    public List<RolEntity> listar() {
        return rolService.listar();
    }

    // ✅ asignar permiso a rol
    @PostMapping("/{idRol}/permisos/{idPermiso}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void asignarPermiso(@PathVariable Integer idRol, @PathVariable Integer idPermiso) {
        rolService.asignarPermiso(idRol, idPermiso);
    }

    // ✅ quitar permiso a rol
    @DeleteMapping("/{idRol}/permisos/{idPermiso}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void quitarPermiso(@PathVariable Integer idRol, @PathVariable Integer idPermiso) {
        rolService.quitarPermiso(idRol, idPermiso);
    }

    // ✅ listar permisos de un rol
    @GetMapping("/{idRol}/permisos")
    public List<PermisoEntity> listarPermisosDeRol(@PathVariable Integer idRol) {
        return rolService.listarPermisosDeRol(idRol);
    }
}