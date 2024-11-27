package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Alumno;
import com.example.Events.Domain.Model.AlumnoConferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlumnoConferencia extends JpaRepository<AlumnoConferencia, Integer> {
    List<AlumnoConferencia> findByNombreContaining(String alumnoConferencia);
}
