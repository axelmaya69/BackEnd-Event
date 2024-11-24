package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdministrador extends JpaRepository<Administrador,Integer > {
}
