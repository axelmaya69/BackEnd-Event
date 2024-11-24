package com.example.Events.Domain.Service;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.Docente;

import java.util.List;

public interface IDocenteService {


    Docente crearDocente(Docente docente);
    Docente obtenerDocente(int id);
    List<Docente> obtenerDocentes();
    List<Docente> obtenerPorNombre(String docente);
    Docente actualizarDocente(int id,Docente docente);
    void eliminarDocente(int id);

}
