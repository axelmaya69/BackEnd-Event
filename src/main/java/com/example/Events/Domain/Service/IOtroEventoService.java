package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.OtroEvento;

import java.util.List;

public interface IOtroEventoService {


    OtroEvento crearOtroEvento(OtroEvento otroEvento);
    OtroEvento obtenerOtroEvento(int id);
    List<OtroEvento> obtenerOtrosEventos();
    List<OtroEvento> obtenerPorNombre(String otroEvento);
    OtroEvento actualizarOtroEvento(int id,OtroEvento otroEvento);
    void eliminarOtroEvento(int id);


}
