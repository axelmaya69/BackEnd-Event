package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.OtroEvento;
import com.example.Events.Domain.Model.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaller extends JpaRepository< Taller , Integer> {
    List<Taller> findByNombreContaining(String nombreTaller);

}
