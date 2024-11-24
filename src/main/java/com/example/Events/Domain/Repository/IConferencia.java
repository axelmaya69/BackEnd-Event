package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Conferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConferencia extends JpaRepository< Conferencia, Integer> {
}
