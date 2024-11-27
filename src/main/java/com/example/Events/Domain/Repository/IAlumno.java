package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Administrador;
import com.example.Events.Domain.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlumno extends JpaRepository< Alumno, Integer> {
    List<Alumno> findByNombreContaining(String nombreAlumno);
}
