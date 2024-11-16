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
    @OneToMany(mappedBy = "alumno")
    private List<AlumnoTaller> AlumTall;

    @Getter
    @Setter
    @OneToMany(mappedBy = "alumno")
    private List<AlumnoConferencia> AlumConf;

    @Getter
    @Setter
    @OneToMany(mappedBy = "alumno")
    private List<Comentario> AlumCom;

    @Getter
    @Setter
    @OneToMany(mappedBy = "alumno")
    private List<MeGusta> AlumMeg;


}

