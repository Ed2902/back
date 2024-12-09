package co.edu.eu.service;

import co.edu.eu.entity.Reporte;
import co.edu.eu.repositoryDAO.IReporteDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReporteService implements IReporteService {

    private final IReporteDAO reporteDAO;

    // Inyección por constructor
    public ReporteService(IReporteDAO reporteDAO) {
        this.reporteDAO = reporteDAO;
    }

    // Operaciones estándar

    @Override
    public Reporte saveReporte(Reporte reporte) {
        return reporteDAO.save(reporte);
    }

    @Override
    public List<Reporte> getAllReportes() {
        return reporteDAO.findAll();
    }

    @Override
    public Reporte getReporteById(int id) {
        return reporteDAO.findById(id);
    }

    @Override
    public boolean deleteReporte(int id) {  // Cambiado a boolean
        try {
            reporteDAO.deleteById(id);
            return true;  // El reporte fue eliminado exitosamente
        } catch (Exception e) {
            return false;  // Hubo un error al eliminar el reporte
        }
    }

    // Consultas personalizadas

    @Override
    public List<Object[]> getReportesConDetalles() {
        return reporteDAO.findReportesConDetalles();
    }

    @Override
    @Transactional
    public boolean updateEstadoReporte(int id, String estado) {
        try {
            reporteDAO.updateEstadoReporte(estado, id);
            return true;  // Estado actualizado correctamente
        } catch (Exception e) {
            return false;  // Hubo un error al actualizar el estado
        }
    }
}
