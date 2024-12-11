package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.IPaqueteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/paquete")
@RestController
public class PaqueteController {

    private final IPaqueteService paqueteService;


    public PaqueteController(IPaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    

}
