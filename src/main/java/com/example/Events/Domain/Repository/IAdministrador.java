package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdministrador extends JpaRepository<Administrador,Integer > {
    List<Administrador> findByNombreContaining(String nombreAdministrador);
}
