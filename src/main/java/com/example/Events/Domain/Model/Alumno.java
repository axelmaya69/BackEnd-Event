package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Alumno  {
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
    @Column(unique = true)
    private String numeroDeControl;

    @Getter
    @Setter
    @Column(unique = true)
    private String usuario;

    @Getter
    @Setter
    private String password;


    @OneToOne
    @Getter
    @Setter
    private Paquete paquete;

    @OneToOne
    @Getter
    @Setter
    private Escuela universidad;

    @OneToMany(mappedBy = "alumno")
    @Getter
    @Setter
    private List<AlumnoConferencia> alumnosConferencia;

    @OneToMany(mappedBy = "alumno")
    @Getter
    @Setter
    private List<AlumnoTaller> alumnosTaller;




}

