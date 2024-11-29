package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Escuela;
import com.example.Events.Domain.Repository.IEscuela;
import com.example.Events.Domain.Service.IEscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscuelaServiceImplementation implements IEscuelaService {

    private final IEscuela escRep;

    @Autowired
    public EscuelaServiceImplementation(IEscuela escRep) {
        this.escRep = escRep;
    }


    @Override
    public Escuela crearEscuela(Escuela escuela) {
        return escRep.save(escuela);
    }

    @Override
    public Escuela obtenerEscuela(int id) {
        return escRep.findById(id).orElse(null);
    }

    @Override
    public List<Escuela> obtenerEscuelas() {
        return escRep.findAll();
    }

    @Override
    public List<Escuela> obtenerPorNombre(String escuela) {
        return escRep.findByNombreContaining(escuela);
    }

    @Override
    public Escuela actualizarEscuela(int id, Escuela escuela) {
        Escuela updateEscuela = escRep.findById(id).get();
        if(escRep.existsById(id)){
            updateEscuela.setNombre(escuela.getNombre());
            return escRep.save(updateEscuela);
        }
        return null;
    }

    @Override
    public void eliminarEscuela(int id) {
    escRep.deleteById(id);
    }
}
