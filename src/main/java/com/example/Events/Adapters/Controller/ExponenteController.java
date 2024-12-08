package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Exponente;
import com.example.Events.Domain.Service.IExponenteService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        try{
            Exponente exponente = exponenteService.obtenerExponente(id);
            return ResponseEntity.ok(exponente);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreExponente){
        try{
            List<Exponente> getExpByName = exponenteService.obtenerPorNombre(nombreExponente);
            return ResponseEntity.ok(getExpByName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postExponente(@RequestBody Exponente exponente){
        try{
            Exponente postExponente = exponenteService.crearExponente(exponente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado exitosamente");
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El registro ya existe!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putExponenteMethod(@PathVariable int id, @RequestBody Exponente exponente){
        try{
            Exponente putExponente = exponenteService.actualizarExponente(id,exponente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado exitosamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMethod(@PathVariable int id){
        try {
            exponenteService.eliminarExponente(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado exitosamente");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }


}
