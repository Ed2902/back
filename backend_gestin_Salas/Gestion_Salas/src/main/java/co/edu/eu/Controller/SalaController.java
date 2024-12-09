package co.edu.eu.Controller;

import co.edu.eu.entity.Sala;
import co.edu.eu.service.ISalaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")  // Permite solicitudes CORS desde cualquier origen
@RequestMapping(value = "/salas")  // Ruta base para todas las operaciones de salas
public class SalaController {

    private final ISalaService service;

    // Inyección por constructor
    public SalaController(ISalaService service) {
        this.service = service;
    }

    // Obtener todas las salas
    @GetMapping(value = "/ver-salas")
    public List<Sala> getAllSalas() {
        return service.getAllSalas();  // Delegamos la solicitud al servicio
    }

    // Obtener una sala por ID
    @GetMapping(value = "/sala-id")
    public Sala getSalaById(@RequestParam("id") int id) {
        return service.getSalaById(id);  // Delegamos la solicitud al servicio
    }

    // Agregar una nueva sala
    @PostMapping(value = "/agregar")
    public ResponseEntity<?> addSala(@Valid @RequestBody Sala sala, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Si hay errores de validación, respondemos con un error 400
        }
        Sala addedSala = service.saveSala(sala);  // Delegamos la solicitud al servicio
        return ResponseEntity.ok(addedSala);  // Respondemos con el objeto sala creado
    }

    // Actualizar una sala existente
    @PutMapping(value = "/actualizar")
    public ResponseEntity<?> updateSala(@Valid @RequestBody Sala sala, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Si hay errores de validación, respondemos con un error 400
        }
        Sala updatedSala = service.updateSala(sala);  // Delegamos la solicitud al servicio
        return ResponseEntity.ok(updatedSala);  // Respondemos con la sala actualizada
    }

    // Eliminar una sala por ID
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<?> deleteSala(@PathVariable("id") int id) {
        boolean isDeleted = service.deleteSala(id);  // Delegamos la solicitud al servicio
        if (isDeleted) {
            return ResponseEntity.ok("Sala eliminada exitosamente");  // Si la eliminación fue exitosa
        } else {
            return ResponseEntity.status(404).body("Sala no encontrada");  // Si no se encuentra la sala para eliminar
        }
    }
}
