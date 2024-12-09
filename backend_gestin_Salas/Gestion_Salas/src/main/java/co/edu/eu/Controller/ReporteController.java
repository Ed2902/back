package co.edu.eu.Controller;

import co.edu.eu.entity.Reporte;
import co.edu.eu.service.IReporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "reportes")
public class ReporteController {

    private final IReporteService reporteService;

    // Constructor con inyección de dependencia
    public ReporteController(IReporteService reporteService) {
        this.reporteService = reporteService;
    }

    // Método para obtener todos los reportes
    @GetMapping("/ver-reportes")
    public List<Reporte> getAllReportes() {
        return reporteService.getAllReportes();
    }

    // Método para obtener un reporte por ID
    @GetMapping("/reporte-id")
    public Reporte getReporteById(@RequestParam("id") int id) {
        return reporteService.getReporteById(id);
    }

    // Método para agregar un nuevo reporte
    @PostMapping("/agregar")
    public ResponseEntity<?> addReporte(@Valid @RequestBody Reporte reporte, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Retorna los errores de validación
        }
        Reporte addedReporte = reporteService.saveReporte(reporte);
        return ResponseEntity.ok(addedReporte);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateEstadoReporte(@PathVariable("id") int id, @RequestParam("estado") String estado) {
        boolean isUpdated = reporteService.updateEstadoReporte(id, estado);
        if (isUpdated) {
            return ResponseEntity.ok("Reporte actualizado exitosamente");
        } else {
            return ResponseEntity.status(404).body("Reporte no encontrado");
        }
    }


    // Método para eliminar un reporte por su ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteReporte(@PathVariable("id") int id) {
        boolean isDeleted = reporteService.deleteReporte(id);
        if (isDeleted) {
            return ResponseEntity.ok("Reporte eliminado exitosamente");
        } else {
            return ResponseEntity.status(404).body("Reporte no encontrado");
        }
    }

    // Método para obtener reportes con detalles personalizados
    @GetMapping("/reportes-detalles")
    public List<Object[]> getReportesConDetalles() {
        return reporteService.getReportesConDetalles();
    }
}
