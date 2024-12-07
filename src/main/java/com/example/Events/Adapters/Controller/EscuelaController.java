package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Escuela;
import com.example.Events.Domain.Service.IEscuelaService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        try{
            Escuela getEscuela = escuelaService.obtenerEscuela(id);
            return ResponseEntity.ok(getEscuela);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreEscuela){
        try{
            List<Escuela> getEscuela = escuelaService.obtenerPorNombre(nombreEscuela);
            return ResponseEntity.ok(getEscuela);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postEscuela(@RequestBody Escuela escuela){
        try{
            Escuela postEscuela1 = escuelaService.crearEscuela(escuela);
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
    public ResponseEntity<?> putEscuela(@PathVariable int id, @RequestBody Escuela escuela){
        try{
            Escuela putEscuela = escuelaService.actualizarEscuela(id, escuela);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado exitosamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEscuela(@PathVariable int id){
        try{
            escuelaService.eliminarEscuela(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado exitosamente");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }


}
