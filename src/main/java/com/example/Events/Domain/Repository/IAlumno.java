package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumno extends JpaRepository< Alumno, Integer> {
}
