package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Taller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaller extends JpaRepository<Integer, Taller> {
}
