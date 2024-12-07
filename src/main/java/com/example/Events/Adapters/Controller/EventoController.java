package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.IEventoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final IEventoService eventoService;


    public EventoController(IEventoService eventoService) {
        this.eventoService = eventoService;
    }
    
}
