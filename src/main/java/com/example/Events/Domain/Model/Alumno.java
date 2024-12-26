package com.example.Events.Domain.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Alumno  extends  APersona{




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

