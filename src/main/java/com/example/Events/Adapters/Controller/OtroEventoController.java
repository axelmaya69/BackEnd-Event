package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Service.IOtroEventoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otroEvento")
public class OtroEventoController {

    private final IOtroEventoService otroEventoService;


    public OtroEventoController(IOtroEventoService otroEventoService) {
        this.otroEventoService = otroEventoService;
    }

    
}
