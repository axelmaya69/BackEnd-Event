package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.IExponenteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exponente")
public class ExponenteController {

    private final IExponenteService exponenteService;


    public ExponenteController(IExponenteService exponenteService) {
        this.exponenteService = exponenteService;
    }

    

}
