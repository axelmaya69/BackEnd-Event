package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.Taller;
import com.example.Events.Domain.Service.ITallerService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taller")
public class TallerController {

    private final ITallerService tallerService;

    public TallerController(ITallerService tallerService) {
        this.tallerService = tallerService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Taller> getTalleres = tallerService.obtenerTalleres();
            return ResponseEntity.ok(getTalleres);
        }
        catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al acceder a la base de datos, intente más tarde.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, intentelo más tarde");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        try{
            Taller getTaller = tallerService.obtenerTaller(id);
            return ResponseEntity.ok(getTaller);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    





}

