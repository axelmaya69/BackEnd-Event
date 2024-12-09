package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Service.ILugarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lugar")
public class LugarController {

    private final ILugarService lugarService;


    public LugarController(ILugarService lugarService) {
        this.lugarService = lugarService;
    }

    
}
