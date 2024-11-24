package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.Taller;

import java.util.List;

public interface ITallerService {

    Taller crearTaller(Taller taller);
    Taller obtenerTaller(int id);
    List<Taller> obtenerTalleres();
    List<Taller> obtenerPorNombre(String taller);
    Taller actualizarTaller(int id, Taller taller);
    void eliminarTaller(int id);

}
