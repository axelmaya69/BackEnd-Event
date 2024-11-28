package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Conferencia;
import com.example.Events.Domain.Repository.IConferencia;
import com.example.Events.Domain.Service.IConferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenciaServiceImplementation implements IConferenciaService {

    private final IConferencia conferenciaRepo;

    @Autowired
    public ConferenciaServiceImplementation(IConferencia conferenciaRepo) {
        this.conferenciaRepo = conferenciaRepo;
    }

    @Override
    public Conferencia crearConferencia(Conferencia conferencia) {
        return conferenciaRepo.save(conferencia);
    }

    @Override
    public Conferencia obtenerConferencia(int id) {
        return conferenciaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Conferencia> obtenerConferencias() {
        return conferenciaRepo.findAll();
    }

    @Override
    public List<Conferencia> obtenerPorNombre(String conferencia) {
        return conferenciaRepo.findByNombreContaining(conferencia);
    }

    @Override
    public Conferencia actualizarConferencia(int id, Conferencia conferencia) {
        Conferencia updateConferencia = conferenciaRepo.findById(id).get();
        if(conferenciaRepo.existsById(id)){
            updateConferencia.setNombre(conferencia.getNombre());
            updateConferencia.setDescripcion(conferencia.getDescripcion());
            updateConferencia.setLugar(conferencia.getLugar());
        }
    }

    @Override
    public void eliminarConferencia(int id) {

    }
}
