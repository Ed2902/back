package co.edu.eu.repositoryDAO;

import co.edu.eu.entity.Reporte;
import co.edu.eu.repositoryJPA.IReporteJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

@Repository
public class ReporteDAO implements IReporteDAO {

    private final IReporteJPA reporteJPA;

    // Inyección por constructor
    public ReporteDAO(IReporteJPA reporteJPA) {
        this.reporteJPA = reporteJPA;
    }

    // Operaciones estándar

    @Override
    public Reporte save(Reporte reporte) {
        return reporteJPA.save(reporte);
    }

    @Override
    public List<Reporte> findAll() {
        return reporteJPA.findAll();
    }

    @Override
    public Reporte findById(int id) {
        return reporteJPA.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        reporteJPA.deleteById(id);
    }

    // Consultas personalizadas

    @Override
    @Query("SELECT r.idReporte, u.nombre AS nombreUsuario, e.nombre AS nombreEquipo, r.descripcion, r.fechaReporte, r.estado " +
           "FROM Reporte r " +
           "JOIN r.usuario u " +
           "JOIN r.equipo e")
    public List<Object[]> findReportesConDetalles() {
        return reporteJPA.findReportesConDetalles();  // Ejecuta la consulta personalizada
    }

    @Override
    @Transactional
    @Modifying
    @Query("UPDATE Reporte r SET r.estado = :estado WHERE r.idReporte = :idReporte")
    public void updateEstadoReporte(String estado, int idReporte) {
        // Ejecuta la consulta para actualizar el estado del reporte
    }
}
