package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.Exponente;

import java.util.List;

public interface IExponenteService {

    Exponente crearExponente(Exponente exponente);
    Exponente obtenerExponente(int id);
    List<Exponente> obtenerExponentes();
    List<Exponente> obtenerPorNombre(String exponente);
    Exponente actualizarExponente(int id, Exponente exponente);
    void eliminarExponente(int id);

}
