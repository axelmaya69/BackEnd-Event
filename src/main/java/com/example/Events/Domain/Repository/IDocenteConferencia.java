package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.DocenteConferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteConferencia extends JpaRepository< DocenteConferencia , Integer> {
}
