package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocente extends JpaRepository<  Docente,Integer> {
}
