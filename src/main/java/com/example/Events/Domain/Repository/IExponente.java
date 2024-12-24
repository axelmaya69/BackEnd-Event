package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Model.Exponente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExponente extends JpaRepository< Exponente , Integer> {
    
    List<Exponente> findByNombreContaining(String nombreExponente);
}
