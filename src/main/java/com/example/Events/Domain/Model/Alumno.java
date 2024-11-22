package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private int id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String apellidoP;

    @Getter
    @Setter
    private String apellidoM;


    @Getter
    @Setter
    private String numeroDeControl;

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private String password;


    @OneToOne
    private Paquete paquete;

    @OneToOne
    private Escuela universidad;


}

