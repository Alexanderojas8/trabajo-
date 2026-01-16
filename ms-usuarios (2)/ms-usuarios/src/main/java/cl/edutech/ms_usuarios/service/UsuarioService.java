package cl.edutech.ms_usuarios.service;

import java.util.List;

import cl.edutech.ms_usuarios.model.dto.UsuarioRequestDTO;
import cl.edutech.ms_usuarios.model.entity.UsuarioEntity;

public interface UsuarioService {

    UsuarioEntity crear(UsuarioRequestDTO dto);

    List<UsuarioEntity> listar();

    UsuarioEntity buscarPorId(int id);

    UsuarioEntity actualizar(int id, UsuarioRequestDTO dto);

    UsuarioEntity desactivar(int id);

    void eliminar(int id);
}