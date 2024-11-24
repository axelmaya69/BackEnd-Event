package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaquete extends JpaRepository< Paquete , Integer> {
}
