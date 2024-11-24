package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.DocenteConferencia;

import java.util.List;

public interface IDocenteConferenciaService {


    DocenteConferencia crearDocenteConferencia (DocenteConferencia docenteConferencia);
    DocenteConferencia obtenerDocenteConferencia(int id);
    List<DocenteConferencia> obtenerDocenteConferencias();
    List<DocenteConferencia> obtenerPorNombre(String docenteConferencia);
    DocenteConferencia actualizarDocenteConferencia(int id, DocenteConferencia docenteConferencia);
    void eliminarDocenteConferencia(int id);
}
