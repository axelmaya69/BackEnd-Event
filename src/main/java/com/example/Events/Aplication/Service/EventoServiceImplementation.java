package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Evento;
import com.example.Events.Domain.Repository.IEvento;
import com.example.Events.Domain.Service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImplementation implements IEventoService {

    private final IEvento eventoRep;

    @Autowired
    public EventoServiceImplementation(IEvento eventoRep) {
        this.eventoRep = eventoRep;
    }


    @Override
    public Evento crearEvento(Evento evento) {
        return eventoRep.save(evento);
    }

    @Override
    public Evento obtenerEvento(int id) {
        return eventoRep.findById(id).orElse(null);
    }

    @Override
    public List<Evento> obtenerEventos() {
        return eventoRep.findAll();
    }


    @Override
    public Evento actualizarEvento(int id, Evento evento) {
        Evento updateEvento = eventoRep.findById(id).get();
        if(eventoRep.existsById(id)){
            updateEvento.setOtrosEventos(evento.getOtrosEventos());
            updateEvento.setConferencias(evento.getConferencias());
            updateEvento.setTalleres(evento.getTalleres());
            return eventoRep.save(updateEvento);
        }
        return null;
    }

    @Override
    public void eliminarEvento(int id) {
    eventoRep.deleteById(id);
    }
}
