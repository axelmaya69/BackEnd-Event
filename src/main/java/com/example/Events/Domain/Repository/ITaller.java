package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaller extends JpaRepository< Taller , Integer> {
}
