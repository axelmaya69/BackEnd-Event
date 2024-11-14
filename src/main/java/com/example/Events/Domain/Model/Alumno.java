package com.example.Events.Domain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    int id;

    @Getter
    @Setter
    String nombre;

    @Getter
    @Setter
    String apellidoP;

    @Getter
    @Setter
    String apellidoM;

}

