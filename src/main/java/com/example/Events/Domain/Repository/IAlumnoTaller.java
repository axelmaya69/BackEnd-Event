package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.AlumnoTaller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoTaller extends JpaRepository< AlumnoTaller , Integer> {
}
