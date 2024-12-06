package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.IEscuelaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/escuela")
public class EscuelaController {

    private final IEscuelaService escuelaService;


    public EscuelaController(IEscuelaService escuelaService) {
        this.escuelaService = escuelaService;
    }

    
}
