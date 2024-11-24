package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Escuela;

import java.util.List;

public interface IEscuelaService {

    Escuela crearEscuela(Escuela escuela);
    Escuela obtenerEscuela(int id);
    List<Escuela> obtenerEscuelas();
    List<Escuela> obtenerPorNombre(String escuela);
    Escuela actualizarEscuela(int id, Escuela escuela);
    void eliminarEscuela(int id);

}
