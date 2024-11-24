package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEscuela extends JpaRepository<Escuela , Integer> {

}
