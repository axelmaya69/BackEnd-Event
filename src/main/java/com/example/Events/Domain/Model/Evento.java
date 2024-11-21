package com.example.Events.Domain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    Date fechaInicio;

    @Getter
    @Setter
    Date fechaFin;

    @Getter
    @Setter
    int fkLugar;

    @Getter
    @Setter
    int fkTaller;

    @Getter
    @Setter
    int fkConferencia;

    @Getter
    @Setter
    int fkOtros;

}
