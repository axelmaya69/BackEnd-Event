package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.OtroEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOtroEvento extends JpaRepository<Integer, OtroEvento> {
}
