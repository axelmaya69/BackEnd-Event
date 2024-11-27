package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.AlumnoConferencia;
import com.example.Events.Domain.Model.DocenteTaller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDocenteTaller extends JpaRepository< DocenteTaller , Integer> {
    List<DocenteTaller> findByNombreContaining(String docenteTaller);
}
