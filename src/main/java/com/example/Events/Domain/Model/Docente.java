package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "docente")
    @Getter
    @Setter
    private List<DocenteConferencia> docenteConferencia;

    @OneToMany(mappedBy = "docente")
    @Getter
    @Setter
    private List<DocenteTaller> docenteTaller;

}
