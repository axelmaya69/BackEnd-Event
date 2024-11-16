package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Conferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConferencia extends JpaRepository<Integer, Conferencia> {
}
