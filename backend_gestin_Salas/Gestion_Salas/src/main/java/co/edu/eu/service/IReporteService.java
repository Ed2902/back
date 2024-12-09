package co.edu.eu.service;

import co.edu.eu.entity.Reporte;
import java.util.List;

public interface IReporteService {
    
    // Operaciones estándar
    Reporte saveReporte(Reporte reporte);
    List<Reporte> getAllReportes();
    Reporte getReporteById(int id);
    boolean deleteReporte(int id);  // Cambiado a boolean
    
    // Consultas personalizadas
    List<Object[]> getReportesConDetalles();
    boolean updateEstadoReporte(int id, String estado);
}
