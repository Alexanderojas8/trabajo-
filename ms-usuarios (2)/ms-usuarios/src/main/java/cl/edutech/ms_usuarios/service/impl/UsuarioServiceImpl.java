package cl.edutech.ms_usuarios.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.edutech.ms_usuarios.model.dto.UsuarioRequestDTO;
import cl.edutech.ms_usuarios.model.entity.UsuarioEntity;
import cl.edutech.ms_usuarios.repository.UsuarioRepository;
import cl.edutech.ms_usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity crear(UsuarioRequestDTO dto) {
        usuarioRepository.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("Ya existe un usuario con ese email");
        });

        UsuarioEntity usuario = UsuarioEntity.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .contrasena(dto.getContrasena())
                .activo(true)
                .build();

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioEntity> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity buscarPorId(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    @Override
    public UsuarioEntity actualizar(int id, UsuarioRequestDTO dto) {
        UsuarioEntity usuario = buscarPorId(id);

        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasena(dto.getContrasena());

        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity desactivar(int id) {
        UsuarioEntity usuario = buscarPorId(id);
        usuario.setActivo(false);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(int id) {
        UsuarioEntity usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }
}