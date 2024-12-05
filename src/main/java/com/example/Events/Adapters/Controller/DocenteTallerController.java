package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Repository.IDocenteTaller;
import com.example.Events.Domain.Service.IDocenteTallerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docenteTaller")
public class DocenteTallerController {

    private final IDocenteTallerService docenteTallerService;


    public DocenteTallerController(IDocenteTallerService docenteTallerService) {
        this.docenteTallerService = docenteTallerService;
    }
}
