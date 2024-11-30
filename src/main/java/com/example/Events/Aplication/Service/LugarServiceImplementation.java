package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Lugar;
import com.example.Events.Domain.Repository.ILugar;
import com.example.Events.Domain.Service.ILugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarServiceImplementation implements ILugarService {

    private final ILugar lugarRep;
    @Autowired
    public LugarServiceImplementation(ILugar lugarRep) {
        this.lugarRep = lugarRep;
    }

    @Override
    public Lugar crearLugar(Lugar lugar) {
        return lugarRep.save(lugar);
    }

    @Override
    public Lugar obtenerLugar(int id) {
        return lugarRep.findById(id).orElse(null);
    }

    @Override
    public List<Lugar> obtenerLugares() {
        return lugarRep.findAll();
    }

    @Override
    public List<Lugar> obtenerPorNombre(String lugar) {
        return lugarRep.findByNombreContaining(lugar);
    }

    @Override
    public Lugar actualizarLugar(int id, Lugar lugar) {
        Lugar updateLugar = lugarRep.findById(id).get();
        if(lugarRep.existsById(id)){
            updateLugar.setLugar(lugar.getLugar());
            return lugarRep.save(updateLugar);
        }
        return null;
    }

    @Override
    public void eliminarLugar(int id) {
    lugarRep.deleteById(id);
    }
}
