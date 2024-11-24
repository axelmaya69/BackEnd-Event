package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.DocenteTaller;

import java.util.List;

public interface IDocenteTallerService {

    DocenteTaller crearDocenteTaller(DocenteTaller docenteTaller);
    DocenteTaller obtenerDocenteTaller(int id);
    List<DocenteTaller> obtenerDocentesTalleres();
    List<DocenteTaller> obtenerPorNombre(String docenteTaller);
    DocenteTaller actualizarDocenteTaller(int id,DocenteTaller docenteTaller);
    void eliminarDocenteTaller(int id);

}
