package cl.edutech.ms_usuarios.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus; 
import cl.edutech.ms_usuarios.model.dto.UsuarioRequestDTO;
import cl.edutech.ms_usuarios.model.entity.UsuarioEntity;
import cl.edutech.ms_usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Crear usuario
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioEntity crear(@Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.crear(dto);
    }

    // Listar usuarios
    @GetMapping
    public List<UsuarioEntity> listar() {
        return usuarioService.listar();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public UsuarioEntity buscar(@PathVariable int id) {
        return usuarioService.buscarPorId(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public UsuarioEntity actualizar(@PathVariable int id, @Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.actualizar(id, dto);
    }

    // Desactivar (requisito)
    @PutMapping("/{id}/desactivar")
    public UsuarioEntity desactivar(@PathVariable int id) {
        return usuarioService.desactivar(id);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        usuarioService.eliminar(id);
    }
}