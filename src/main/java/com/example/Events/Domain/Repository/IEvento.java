package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvento extends JpaRepository< Evento , Integer> {
}
