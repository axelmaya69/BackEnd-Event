package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Model.Conferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConferencia extends JpaRepository< Conferencia, Integer> {

    List<Conferencia> findByNombreContaining(String nombreConferencia);
}
