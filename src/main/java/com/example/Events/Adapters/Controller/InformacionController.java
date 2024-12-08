package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.IInformacionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/informacionController")
public class InformacionController {

    private final IInformacionService informacionService;

    public InformacionController(IInformacionService informacionService) {
        this.informacionService = informacionService;
    }

    



}
