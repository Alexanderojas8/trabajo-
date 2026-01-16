package cl.edutech.ms_permisos.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PermisoRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
}

