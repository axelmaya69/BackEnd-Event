package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.OtroEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOtroEvento extends JpaRepository< OtroEvento , Integer> {
}
