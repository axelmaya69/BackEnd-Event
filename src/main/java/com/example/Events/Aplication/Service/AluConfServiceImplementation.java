package com.example.Events.Aplication.Service;

import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Service.IAlumnoConferenciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluConfServiceImplementation implements IAlumnoConferenciaService {
    @Override
    public AlumnoConferencia crearAlumnoConferencia(AlumnoConferencia alumnoConferencia) {
        return null;
    }

    @Override
    public AlumnoConferencia obtenerAlumnoConferencia(int id) {
        return null;
    }

    @Override
    public List<AlumnoConferencia> obtenerAlumnosConferencias() {
        return List.of();
    }

    @Override
    public List<AlumnoConferencia> obtenerPorNombre(String alumnoConferencia) {
        return List.of();
    }

    @Override
    public AlumnoConferencia actualizarAlumnoConferencia(int id, AlumnoConferencia alumnoConferencia) {
        return null;
    }

    @Override
    public void eliminarAlumnoConferencia(int id) {

    }
}
