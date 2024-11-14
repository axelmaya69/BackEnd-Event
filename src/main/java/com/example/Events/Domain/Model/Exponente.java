package com.example.Events.Domain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Exponente {
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
    String apellidoP;

    @Getter
    @Setter
    String apellidoM;

    @Getter
    @Setter
    String correoElectronico;

    @Getter
    @Setter
    String descripcion;

}
