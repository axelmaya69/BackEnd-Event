package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Administrador;
import com.example.Events.Domain.Repository.IAdministrador;
import com.example.Events.Domain.Service.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImplementation implements IAdministradorService {

    private final IAdministrador adminRep;

    @Autowired
    public AdministradorServiceImplementation(IAdministrador adminRep) {
        this.adminRep = adminRep;
    }



    @Override
    public Administrador crearAdministrador(Administrador administrador) {
        return adminRep.save(administrador);
    }

    @Override
    public Administrador obtenerAdministrador(int id) {
        return adminRep.findById(id).orElse(null);
    }

    @Override
    public List<Administrador> obtenerAdministradores() {
        return adminRep.findAll();
    }

    @Override
    public List<Administrador> obtenerPorNombre(String administrador) {
        return adminRep.findByNombreContaining(administrador);
    }

    @Override
    public Administrador actualizarAdministrador(int id, Administrador administrador) {
        Administrador updateAdministrador = adminRep.findById(id).get();
        if(adminRep.existsById(id)){
            updateAdministrador.setNombre(administrador.getNombre());
            updateAdministrador.setRol(administrador.getRol());
            return adminRep.save(updateAdministrador);
        }
        return null;
    }

    @Override
    public void eliminarAdministrador(int id) {
    adminRep.deleteById(id);
    }
}
