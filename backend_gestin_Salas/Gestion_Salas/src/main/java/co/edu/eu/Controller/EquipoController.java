package co.edu.eu.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.eu.entity.Equipo;
import co.edu.eu.service.IEquipoService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "equipos")
public class EquipoController {

    private final IEquipoService service;

    // Inyección por constructor
    public EquipoController(IEquipoService service) {
        this.service = service;
    }

    // Obtener todos los equipos
    @GetMapping(value = "/ver-equipos")
    public List<Equipo> getAllEquipos() {
        return service.getAllEquipos();
    }

    // Obtener un equipo por ID
    @GetMapping(value = "/equipo-id")
    public Equipo getEquipoById(@RequestParam("id") int id) {
        return service.getEquipoById(id);  // Buscar por ID
    }

    // Agregar un nuevo equipo
    @PostMapping(value = "/agregar")
    public ResponseEntity<?> addEquipo(@Valid @RequestBody Equipo equipo, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Si hay errores de validación
        }
        Equipo addedEquipo = service.saveEquipo(equipo);  // Guardar equipo
        return ResponseEntity.ok(addedEquipo);  // Responder con el equipo agregado
    }

    @PutMapping(value = "/actualizar-detalles")
    public ResponseEntity<?> updateEquipoDetails(@RequestBody Map<String, Object> equipoDetails) {
        try {
            int idSala = (int) equipoDetails.get("idSala");
            String nombre = (String) equipoDetails.get("nombre");
            String tipo = (String) equipoDetails.get("tipo");
            int idEquipo = (int) equipoDetails.get("idEquipo");

            // Llamamos al servicio para actualizar los detalles del equipo
            service.updateEquipoDetails(idSala, nombre, tipo, idEquipo);
            return ResponseEntity.ok("Equipo actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el equipo: " + e.getMessage());
        }
    }

}
