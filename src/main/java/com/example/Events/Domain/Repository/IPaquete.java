package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaquete extends JpaRepository<Integer, Paquete> {
}
