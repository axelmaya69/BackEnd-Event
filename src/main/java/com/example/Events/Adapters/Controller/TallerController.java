package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Service.ITallerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taller")
public class TallerController {

    private final ITallerService tallerService;

    public TallerController(ITallerService tallerService) {
        this.tallerService = tallerService;
    }
}
