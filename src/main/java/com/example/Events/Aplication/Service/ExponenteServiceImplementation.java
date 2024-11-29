package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Exponente;
import com.example.Events.Domain.Repository.IExponente;
import com.example.Events.Domain.Service.IExponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExponenteServiceImplementation implements IExponenteService {

    private final IExponente expoRep;

    @Autowired
    public ExponenteServiceImplementation(IExponente expoRep) {
        this.expoRep = expoRep;
    }


    @Override
    public Exponente crearExponente(Exponente exponente) {
        return expoRep.save(exponente);
    }

    @Override
    public Exponente obtenerExponente(int id) {
        return expoRep.findById(id).orElse(null);
    }

    @Override
    public List<Exponente> obtenerExponentes() {
        return expoRep.findAll();
    }

    @Override
    public List<Exponente> obtenerPorNombre(String exponente) {
        return expoRep.findByNombreContaining(exponente);
    }

    @Override
    public Exponente actualizarExponente(int id, Exponente exponente) {
        Exponente updateExponente = expoRep.findById(id).get();
        if(expoRep.existsById(id)){
            updateExponente.setNombre(exponente.getNombre());
            updateExponente.setApellidoP(exponente.getApellidoP());
            updateExponente.setApellidoM(exponente.getApellidoM());
            updateExponente.setCorreoElectronico(exponente.getCorreoElectronico());
            updateExponente.setDescripcion(exponente.getDescripcion());
            return expoRep.save(updateExponente);
        }
        return null;
    }

    @Override
    public void eliminarExponente(int id) {
    expoRep.deleteById(id);
    }
}
