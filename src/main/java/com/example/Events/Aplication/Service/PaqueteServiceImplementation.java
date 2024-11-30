package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Paquete;
import com.example.Events.Domain.Repository.IPaquete;
import com.example.Events.Domain.Service.IPaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteServiceImplementation implements IPaqueteService {

    private final IPaquete paqRep;

    @Autowired
    public PaqueteServiceImplementation(IPaquete paqRep) {
        this.paqRep = paqRep;
    }

    @Override
    public Paquete crearPaquete(Paquete paquete) {
        return paqRep.save(paquete);
    }

    @Override
    public Paquete obtenerPaquete(int id) {
        return paqRep.findById(id).orElse(null);
    }

    @Override
    public List<Paquete> obtenerPaquetes() {
        return paqRep.findAll();
    }

    @Override
    public List<Paquete> obtenerPorNombre(String paquete) {
        return paqRep.findByNombreContaining(paquete);
    }

    @Override
    public Paquete actualizarPaquete(int id, Paquete paquete) {
        Paquete updatePaquete = paqRep.findById(id).get();
        if(paqRep.existsById(id)){
            updatePaquete.setTipo(paquete.getTipo());
            return paqRep.save(updatePaquete);
        }
        return null;
    }

    @Override
    public void eliminarPaquete(int id) {
    paqRep.deleteById(id);
    }
}
