package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.OtroEvento;
import com.example.Events.Domain.Repository.IOtroEvento;
import com.example.Events.Domain.Service.IOtroEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtroEvServiceImplementation implements IOtroEventoService {

    private final IOtroEvento otroEvRep;

    @Autowired
    public OtroEvServiceImplementation(IOtroEvento otroEvRep) {
        this.otroEvRep = otroEvRep;
    }

    @Override
    public OtroEvento crearOtroEvento(OtroEvento otroEvento) {
        return otroEvRep.save(otroEvento);
    }

    @Override
    public OtroEvento obtenerOtroEvento(int id) {
        return otroEvRep.findById(id).orElse(null);
    }

    @Override
    public List<OtroEvento> obtenerOtrosEventos() {
        return otroEvRep.findAll();
    }

    @Override
    public List<OtroEvento> obtenerPorNombre(String otroEvento) {
        return otroEvRep.findByNombreContaining(otroEvento);
    }

    @Override
    public OtroEvento actualizarOtroEvento(int id, OtroEvento otroEvento) {
        OtroEvento updateOtroEv = otroEvRep.findById(id).get();
        if(otroEvRep.existsById(id)){
            updateOtroEv.setNombre(otroEvento.getNombre());
            updateOtroEv.setDescripcion(otroEvento.getDescripcion());
            return otroEvRep.save(updateOtroEv);
        }
        return null;
    }

    @Override
    public void eliminarOtroEvento(int id) {
    otroEvRep.deleteById(id);
    }
}
