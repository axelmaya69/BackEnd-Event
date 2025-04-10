package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.Taller;
import com.example.Events.Domain.Service.ITallerService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreTaller){
        try{
            List<Taller> getTallersByName = tallerService.obtenerPorNombre(nombreTaller);
            return ResponseEntity.ok(getTallersByName);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postTaller(@RequestBody Taller taller){
        try{
            Taller postTaller = tallerService.crearTaller(taller);
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
    public ResponseEntity<?> putTaller(@PathVariable int id, @RequestBody Taller taller){
        try{
            Taller putTaller1 = tallerService.actualizarTaller(id,taller);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado exitosamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTaller(@PathVariable int id){
        try{
            tallerService.eliminarTaller(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado con exito");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }



}

