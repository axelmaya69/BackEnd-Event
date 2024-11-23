package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class DocenteConferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    int id;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    @Getter
    @Setter
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "id_conferencia")
    @Getter
    @Setter
    private Conferencia conferencia;



}
