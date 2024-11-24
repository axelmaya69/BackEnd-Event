package com.example.Events.Domain.Repository;

import com.example.Events.Domain.Model.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformacion extends JpaRepository<Informacion , Integer> {
}
