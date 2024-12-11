package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Paquete;
import com.example.Events.Domain.Service.IPaqueteService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/paquete")
@RestController
public class PaqueteController {

    private final IPaqueteService paqueteService;


    public PaqueteController(IPaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }


    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        try{
            List<Paquete> getPaquetes = paqueteService.obtenerPaquetes();
            return ResponseEntity.ok(getPaquetes);
        }
        catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al acceder a la base de datos, intente más tarde.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, intentelo más tarde");
        }
    }

    

}
