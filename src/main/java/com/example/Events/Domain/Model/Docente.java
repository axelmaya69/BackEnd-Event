package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Docente extends APersona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Setter
    @Getter
    private int id;

    @Getter
    @Setter
    @Column(unique = true)
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
