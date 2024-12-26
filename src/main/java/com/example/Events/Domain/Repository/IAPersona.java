package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.APersona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAPersona extends JpaRepository<APersona, Integer> {
}
