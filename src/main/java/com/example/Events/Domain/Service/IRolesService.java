package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.APersona;
import com.example.Events.Domain.Model.Rol;

public interface IRolesService {

    Rol crearRol(String nombre, String descripcion);

    void asignarRol(APersona persona, String nombreRol);
}
