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
    @OneToMany(mappedBy = "alumno")
    private List<InscripcionTaller> AlumTall;

    @Getter
    @Setter
    @OneToMany(mappedBy = "alumno")
    private List<InscripcionConferencia> AlumConf;

 


}

