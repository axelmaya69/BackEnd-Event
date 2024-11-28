package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Model.Conferencia;

import java.util.List;

public interface IConferenciaService {

    Conferencia crearConferencia (Conferencia conferencia);
    Conferencia obtenerConferencia(int id);
    List<Conferencia> obtenerConferencias();
    List<Conferencia> obtenerPorNombre(String conferencia);
    Conferencia actualizarConferencia(int id, Conferencia conferencia);
    void eliminarConferencia(int id);
}
