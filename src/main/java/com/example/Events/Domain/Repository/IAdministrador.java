package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdministrador extends JpaRepository<Integer, Administrador> {
}
