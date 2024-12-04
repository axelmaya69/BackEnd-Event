package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.IDocenteConferenciaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docenteConferencia")
public class DocenteConferenciaController {

    private final IDocenteConferenciaService docenteConferenciaService;


    public DocenteConferenciaController(IDocenteConferenciaService docenteConferenciaService) {
        this.docenteConferenciaService = docenteConferenciaService;
    }
    
}
