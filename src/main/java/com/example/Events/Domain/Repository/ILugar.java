package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILugar extends JpaRepository< Lugar, Integer> {
}
