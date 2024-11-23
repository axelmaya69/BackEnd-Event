package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;

import java.util.List;

public interface IAlumnoService {

    Alumno crearAlumno(Alumno alumno);
    Alumno obtenerAlumno(int id);
    List<Alumno> obtenerAlumnos();
    List<Alumno> obtenerPorNombre(String alumno);
    Alumno actualizarAlumno(int id,Alumno alumno);
    void eliminarAlumno(int id);

}
