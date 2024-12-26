package com.example.Events.Domain.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass //
public abstract class APersona {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    String numeroDeControl;

    @Getter
    @Setter
    @Column(unique = true)
    private String usuario;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles = new ArrayList<>(); // Relación dinámica con roles
}
