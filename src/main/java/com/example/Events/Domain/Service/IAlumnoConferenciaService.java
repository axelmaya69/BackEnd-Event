package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.AlumnoConferencia;

import java.util.List;

public interface IAlumnoConferenciaService {

    AlumnoConferencia crearAlumnoConferencia (AlumnoConferencia alumnoConferencia);
    AlumnoConferencia obtenerAlumnoConferencia(int id);
    List<AlumnoConferencia> obtenerAlumnosConferencias();
    AlumnoConferencia actualizarAlumnoConferencia(int id,AlumnoConferencia alumnoConferencia);
    void eliminarAlumnoConferencia(int id);

}
