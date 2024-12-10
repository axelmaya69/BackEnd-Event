package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Lugar;
import com.example.Events.Domain.Service.ILugarService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lugar")
public class LugarController {

    private final ILugarService lugarService;


    public LugarController(ILugarService lugarService) {
        this.lugarService = lugarService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Lugar> getAllLugares = lugarService.obtenerLugares();
            return ResponseEntity.ok(getAllLugares);
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
            Lugar getLugar = lugarService.obtenerLugar(id);
            return ResponseEntity.ok(getLugar);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String nombreLugar){
        try{
            List<Lugar> getLugaresByName = lugarService.obtenerPorNombre(nombreLugar);
            return ResponseEntity.ok(getLugaresByName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postLugar(@RequestBody Lugar lugar){
        try{
            Lugar postLugar = lugarService.crearLugar(lugar);
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
    public ResponseEntity<?> putLugar(@PathVariable int id,@RequestBody Lugar lugar){
        try{
            Lugar putLugar = lugarService.actualizarLugar(id,lugar);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado exitosamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLugar(@PathVariable int id){
        try{
            lugarService.eliminarLugar(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado exitosamente");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }


}
