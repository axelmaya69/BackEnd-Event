package com.example.Events.Adapters.Controller;


import com.example.Events.Domain.Model.Evento;
import com.example.Events.Domain.Service.IEventoService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final IEventoService eventoService;


    public EventoController(IEventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<Evento> getEventos = eventoService.obtenerEventos();
            return ResponseEntity.ok(getEventos);
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
            Evento getEvento = eventoService.obtenerEvento(id);
            return ResponseEntity.ok(getEvento);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postEvento(@RequestBody Evento evento){
        try{
            Evento postEvento1 = eventoService.crearEvento(evento);
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
    public ResponseEntity<?> putEvento(@PathVariable int id, @RequestBody Evento evento){
        try{
            Evento putEvento = eventoService.actualizarEvento(id, evento);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado exitosamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }
}
