package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Service.IAlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlumnoServiceImplementation implements IAlumnoService {
    @Override
    public Alumno crearAlumno(Alumno alumno) {
        return null;
    }

    @Override
    public Alumno obtenerAlumno(int id) {
        return null;
    }

    @Override
    public List<Alumno> obtenerAlumnos() {
        return List.of();
    }

    @Override
    public List<Alumno> obtenerPorNombre(String alumno) {
        return List.of();
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumno) {
        return null;
    }

    @Override
    public void eliminarAlumno(int id) {

    }
}
