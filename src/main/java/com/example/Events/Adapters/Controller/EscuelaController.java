package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Escuela;
import com.example.Events.Domain.Service.IEscuelaService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escuela")
public class EscuelaController {

    private final IEscuelaService escuelaService;


    public EscuelaController(IEscuelaService escuelaService) {
        this.escuelaService = escuelaService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Escuela> getAll = escuelaService.obtenerEscuelas();
            return ResponseEntity.ok(getAll);
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
