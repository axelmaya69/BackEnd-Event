package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Exponente;
import com.example.Events.Domain.Service.IExponenteService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exponente")
public class ExponenteController {

    private final IExponenteService exponenteService;


    public ExponenteController(IExponenteService exponenteService) {
        this.exponenteService = exponenteService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try {
            List<Exponente> getExponentes = exponenteService.obtenerExponentes();
            return ResponseEntity.ok(getExponentes);
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
