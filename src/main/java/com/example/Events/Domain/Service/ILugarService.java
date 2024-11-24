package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Lugar;

import java.util.List;

public interface ILugarService {

    Lugar crearLugar(Lugar lugar);
    Lugar obtenerLugar(int id);
    List<Lugar> obtenerLugares();
    List<Lugar> obtenerPorNombre(String lugar);
    Lugar actualizarLugar(int id, Lugar lugar);
    void eliminarLugar(int id);

}
