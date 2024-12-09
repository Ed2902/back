package co.edu.eu.repositoryDAO;

import co.edu.eu.entity.Reporte;
import java.util.List;

public interface IReporteDAO {
    
    // Operaciones estándar
    Reporte save(Reporte reporte);
    List<Reporte> findAll();
    Reporte findById(int id);
    void deleteById(int id);
    
    // Consultas personalizadas
    List<Object[]> findReportesConDetalles();  // Consulta personalizada para obtener reportes con detalles
    void updateEstadoReporte(String estado, int idReporte);  // Actualiza el estado de un reporte
}
