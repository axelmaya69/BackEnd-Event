package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILugar extends JpaRepository<Integer, Lugar> {
}
