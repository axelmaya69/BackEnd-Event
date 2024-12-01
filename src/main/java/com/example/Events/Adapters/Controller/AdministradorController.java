package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Administrador;
import com.example.Events.Domain.Service.IAdministradorService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    private final IAdministradorService administradorService;


    public AdministradorController(IAdministradorService administradorService) {
        this.administradorService = administradorService;
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Administrador> administradors= administradorService.obtenerAdministradores();
            return ResponseEntity.ok(administradors);
        }catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al acceder a la base de datos, intente más tarde.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, intentelo más tarde");
        }
    }
    @GetMapping("/getByName")
    public  ResponseEntity<?> getByName(@RequestParam String nombreAdministrador){
        try{
            List<Administrador> getAdministrador= administradorService.obtenerPorNombre(nombreAdministrador);
            return ResponseEntity.ok(getAdministrador);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
    try {
        Administrador getAdministrador = administradorService.obtenerAdministrador(id);
        return ResponseEntity.ok(getAdministrador);
    }catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error, inténtelo más tarde.");
    }
    }
    @PostMapping("/post")
    public ResponseEntity<?> postAdministrador (@RequestBody Administrador administrador){
        try{
            Administrador postAdministrador = administradorService.crearAdministrador(administrador);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado con éxito");
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Producto ya existe!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }
}
