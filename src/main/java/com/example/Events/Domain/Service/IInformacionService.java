package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Evento;
import com.example.Events.Domain.Model.Informacion;

import java.util.List;

public interface IInformacionService {

    Informacion crearInformacion(Informacion informacion);
    Informacion obtenerInformacion(int id);
    List<Informacion> obtenerInformaciones();

    Informacion actualizarInformacion(int id, Informacion informacion);
    void eliminarInformacion(int id);
}
