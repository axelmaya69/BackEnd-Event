package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.Evento;

import java.util.List;

public interface IEventoService {

    Evento crearEvento(Evento evento);
    Evento obtenerEvento(int id);
    List<Evento> obtenerEventos();
    List<Evento> obtenerPorNombre(String evento);
    Evento actualizarEvento(int id, Evento evento);
    void eliminarEvento(int id);

}
