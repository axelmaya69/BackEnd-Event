package com.example.Events.Domain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
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
    private String numeroControl;

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private String password;

}
