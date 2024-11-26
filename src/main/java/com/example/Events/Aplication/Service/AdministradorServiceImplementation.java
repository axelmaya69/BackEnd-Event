package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Administrador;
import com.example.Events.Domain.Service.IAdministradorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImplementation implements IAdministradorService {
    @Override
    public Administrador crearAdministrador(Administrador administrador) {
        return null;
    }

    @Override
    public Administrador obtenerAdministrador(int id) {
        return null;
    }

    @Override
    public List<Administrador> obtenerAdministradores() {
        return List.of();
    }

    @Override
    public List<Administrador> obtenerPorNombre(String administrador) {
        return List.of();
    }

    @Override
    public Administrador actualizarAdministrador(int id, Administrador administrador) {
        return null;
    }

    @Override
    public void eliminarAdministrador(int id) {

    }
}
