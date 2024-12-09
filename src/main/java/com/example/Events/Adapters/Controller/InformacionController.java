package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Informacion;
import com.example.Events.Domain.Service.IInformacionService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informacionController")
public class InformacionController {

    private final IInformacionService informacionService;

    public InformacionController(IInformacionService informacionService) {
        this.informacionService = informacionService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Informacion> getAllInfo = informacionService.obtenerInformaciones();
            return ResponseEntity.ok(getAllInfo);
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
    public  ResponseEntity<?> getById(@PathVariable int id){
        try{
            Informacion getInformacion = informacionService.obtenerInformacion(id);
            return ResponseEntity.ok(getInformacion);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postInf(@RequestBody Informacion informacion){
        try{
            Informacion postInformacion = informacionService.crearInformacion(informacion);
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
    public ResponseEntity<?> putInf(@PathVariable int id, @RequestBody Informacion informacion){
        try{
            Informacion putInformacion = informacionService.actualizarInformacion(id,informacion);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado con exito");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    

}
