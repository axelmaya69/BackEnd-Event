package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvento extends JpaRepository<Integer, Evento> {
}
