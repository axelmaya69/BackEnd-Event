package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Taller;
import com.example.Events.Domain.Repository.ITaller;
import com.example.Events.Domain.Service.ITallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallerServiceImplementation implements ITallerService {

    private final ITaller tallerRep;
    @Autowired
    public TallerServiceImplementation(ITaller tallerRep) {
        this.tallerRep = tallerRep;
    }

    @Override
    public Taller crearTaller(Taller taller) {
        return tallerRep.save(taller);
    }

    @Override
    public Taller obtenerTaller(int id) {
        return tallerRep.findById(id).orElse(null);
    }

    @Override
    public List<Taller> obtenerTalleres() {
        return tallerRep.findAll();
    }

    @Override
    public List<Taller> obtenerPorNombre(String taller) {
        return tallerRep.findByNombreContaining(taller);
    }

    @Override
    public Taller actualizarTaller(int id, Taller taller) {
        Taller updateTaller = tallerRep.findById(id).get();
        if(tallerRep.existsById(id)){
            updateTaller.setNombre(taller.getNombre());
            updateTaller.setDescripcion(taller.getDescripcion());
            updateTaller.setMateriales(taller.getMateriales());
            updateTaller.setExponente(taller.getExponente());
            updateTaller.setPaquete(taller.getPaquete());
            updateTaller.setLugar(taller.getLugar());
            updateTaller.setInformacion(taller.getInformacion());
            return tallerRep.save(updateTaller);
        }
        return null;
    }

    @Override
    public void eliminarTaller(int id) {
    tallerRep.deleteById(id);
    }
}
