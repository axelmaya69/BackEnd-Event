package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Informacion;
import com.example.Events.Domain.Service.IInformacionService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
