package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.Paquete;

import java.util.List;

public interface IPaqueteService {

    Paquete crearPaquete(Paquete paquete);
    Paquete obtenerPaquete(int id);
    List<Paquete> obtenerPaquetes();
    List<Paquete> obtenerPorNombre(String paquete);
    Paquete actualizarPaquete(int id,Paquete paquete);
    void eliminarPaquete(int id);

}
