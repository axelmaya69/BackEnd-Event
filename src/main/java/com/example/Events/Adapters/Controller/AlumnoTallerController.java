package com.example.Events.Adapters.Controller;

import com.example.Events.Domain.Model.AlumnoTaller;
import com.example.Events.Domain.Service.IAlumnoTallerService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnoTaller")
public class AlumnoTallerController {

    private final IAlumnoTallerService alumnoTallerService;

    public AlumnoTallerController(IAlumnoTallerService alumnoTallerService) {
        this.alumnoTallerService = alumnoTallerService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try{
            List<AlumnoTaller> getAlTall = alumnoTallerService.obtenerAlumnosTalleres();
            return ResponseEntity.ok(getAlTall);
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
    public ResponseEntity<?> getById (@PathVariable int id){
        try{
            AlumnoTaller updateAlTall = alumnoTallerService.obtenerAlumnoTaller(id);
            return  ResponseEntity.ok(updateAlTall);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postAlTall(@RequestBody AlumnoTaller alumnoTaller){
        try{
            AlumnoTaller postAlTall = alumnoTallerService.crearAlumnoTaller(alumnoTaller);
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
    public ResponseEntity<?> putAlTall(@PathVariable int id, @RequestBody AlumnoTaller alumnoTaller){
        try{
            AlumnoTaller putAlTall = alumnoTallerService.actualizarAlumnoTaller(id,alumnoTaller);
            return ResponseEntity.status(HttpStatus.CREATED).body("Actualizado exitosamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde");
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAlTall(@PathVariable int id){
        try{
            alumnoTallerService.eliminarAlumnoTaller(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Eliminado exitosamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                    " inténtelo más tarde.");
        }
    }

}
