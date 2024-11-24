package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Administrador;
import com.example.Events.Domain.Model.Alumno;

import java.util.List;

public interface IAdministradorService {

    Administrador crearAdministrador(Administrador administrador);
    Administrador obtenerAdministrador(int id);
    List<Administrador> obtenerAdministradores();
    List<Administrador> obtenerPorNombre(String administrador);
    Administrador actualizarAdministrador(int id,Administrador administrador);
    void eliminarAdministrador(int id);
}
