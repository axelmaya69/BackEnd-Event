package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRol extends JpaRepository<Rol,Integer> {
    Optional<Rol> findByNombre(String nombre);

}
