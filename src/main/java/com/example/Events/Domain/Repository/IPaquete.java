package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.OtroEvento;
import com.example.Events.Domain.Model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaquete extends JpaRepository< Paquete , Integer> {
    List<Paquete> findByTipoContaining(String nombrePaquete);

}
