package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumno extends JpaRepository<Integer, Alumno> {
}
