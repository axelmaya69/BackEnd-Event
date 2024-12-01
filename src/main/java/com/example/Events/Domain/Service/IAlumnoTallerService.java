package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.AlumnoTaller;

import java.util.List;

public interface IAlumnoTallerService {

    AlumnoTaller crearAlumnoTaller (AlumnoTaller alumnotaller);
    AlumnoTaller obtenerAlumnoTaller(int id);
    List<AlumnoTaller> obtenerAlumnosTalleres();
    AlumnoTaller actualizarAlumnoTaller(int id,AlumnoTaller alumnotaller);
    void eliminarAlumnoTaller(int id);
}
