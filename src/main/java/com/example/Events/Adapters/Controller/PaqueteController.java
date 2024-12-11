package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Paquete;
import com.example.Events.Domain.Service.IPaqueteService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        try{
            Paquete getPaquete = paqueteService.obtenerPaquete(id);
            return ResponseEntity.ok(getPaquete);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombrePaquete){
        try{
            List<Paquete> getPaqueteName = paqueteService.obtenerPorNombre(nombrePaquete);
            return ResponseEntity.ok(getPaqueteName);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postPaquete(@RequestBody Paquete paquete){
        try{
            Paquete postPaquete = paqueteService.crearPaquete(paquete);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado con exito");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El registro ya existe!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }
    

}
