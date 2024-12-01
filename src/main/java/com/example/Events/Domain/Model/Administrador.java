package com.example.Events.Domain.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String rol;

    @Getter
    @Setter
    @Column(unique = true)
    private String nombre;
}
