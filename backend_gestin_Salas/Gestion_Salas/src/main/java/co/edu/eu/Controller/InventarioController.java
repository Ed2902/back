package co.edu.eu.Controller;

import co.edu.eu.entity.Inventario;
import co.edu.eu.service.IInventarioService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "inventarios")
public class InventarioController {

    private final IInventarioService inventarioService;

    // Inyección por constructor
    public InventarioController(IInventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    // Obtener todos los inventarios
    @GetMapping("/ver-inventarios")
    public List<Inventario> getAllInventarios() {
        return inventarioService.getAllInventarios();
    }

    // Obtener un inventario por ID
    @GetMapping("/inventario-id")
    public Inventario getInventarioById(@RequestParam("id") int id) {
        return inventarioService.getInventarioById(id);
    }

    // Agregar un nuevo inventario
    @PostMapping("/agregar")
    public ResponseEntity<?> addInventario(@Valid @RequestBody Inventario inventario, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Si hay errores de validación
        }
        Inventario addedInventario = inventarioService.saveInventario(inventario);
        return ResponseEntity.ok(addedInventario);
    }

    // Actualizar un inventario existente
    @PutMapping("/actualizar")
    public ResponseEntity<?> updateInventario(@Valid @RequestBody Inventario inventario, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Si hay errores de validación
        }
        Inventario updatedInventario = inventarioService.saveInventario(inventario);
        return ResponseEntity.ok(updatedInventario);
    }

    // Eliminar un inventario
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteInventario(@PathVariable("id") int id) {
        Inventario inventario = inventarioService.getInventarioById(id);
        if (inventario != null) {
            inventarioService.deleteInventarioById(id);
            return ResponseEntity.ok("Inventario eliminado exitosamente");
        } else {
            return ResponseEntity.status(404).body("Inventario no encontrado");
        }
    }

    // Consulta personalizada: Obtener equipos con sus dispositivos
    @GetMapping("/equipos-con-dispositivos")
    public ResponseEntity<?> getEquiposConDispositivos() {
        List<Object[]> resultados = inventarioService.getEquiposConDispositivos();
        return ResponseEntity.ok(resultados);
    }
}
