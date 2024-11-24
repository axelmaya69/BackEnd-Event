package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.AlumnoConferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoConferencia extends JpaRepository<AlumnoConferencia, Integer> {
}
