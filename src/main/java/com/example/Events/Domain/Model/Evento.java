package com.example.Events.Domain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String nombre;

    @Getter
    @Setter
    String descripcion;

    @Getter
    @Setter
    Date fechaInicio;

    @Getter
    @Setter
    Date fechaFin;
}
