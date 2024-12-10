package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.OtroEvento;
import com.example.Events.Domain.Service.IOtroEventoService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otroEvento")
public class OtroEventoController {

    private final IOtroEventoService otroEventoService;


    public OtroEventoController(IOtroEventoService otroEventoService) {
        this.otroEventoService = otroEventoService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<OtroEvento> getAllOEv = otroEventoService.obtenerOtrosEventos();
            return ResponseEntity.ok(getAllOEv);
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
            OtroEvento getOtroEvento = otroEventoService.obtenerOtroEvento(id);
            return ResponseEntity.ok(getOtroEvento);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreOtroEvento){
        try{
            List<OtroEvento> getOtroEv = otroEventoService.obtenerPorNombre(nombreOtroEvento);
            return ResponseEntity.ok(getOtroEv);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postOtroEv(@RequestBody OtroEvento otroEvento){
        try{
            OtroEvento postOtroEvento = otroEventoService.crearOtroEvento(otroEvento);
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
    public ResponseEntity<?> putOtroEvento(@PathVariable int id, @RequestBody OtroEvento otroEvento){
        try{
            OtroEvento putOtroEvento = otroEventoService.actualizarOtroEvento(id, otroEvento);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado exitosamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOtroEv(@PathVariable int id){
        try{
            otroEventoService.eliminarOtroEvento(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado con exito");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }
}
