package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocente extends JpaRepository<Integer, Docente> {
}
