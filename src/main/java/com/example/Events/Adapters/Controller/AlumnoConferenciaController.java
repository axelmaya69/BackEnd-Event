package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.IAlumnoConferenciaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AlumnoConferencia")
public class AlumnoConferenciaController {

    private final IAlumnoConferenciaService alumnoConferenciaService;


    public AlumnoConferenciaController(IAlumnoConferenciaService alumnoConferenciaService) {
        this.alumnoConferenciaService = alumnoConferenciaService;
    }

    @GetMapping("/get")
    



}
