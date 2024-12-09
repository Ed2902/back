package co.edu.eu.repositoryJPA;

import co.edu.eu.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReporteJPA extends JpaRepository<Reporte, Integer> {

    // Consulta personalizada para obtener los reportes con usuario y equipo
    @Query("SELECT r.idReporte, u.nombre AS nombreUsuario, e.nombre AS nombreEquipo, r.descripcion, r.fechaReporte, r.estado " +
           "FROM Reporte r " +
           "JOIN r.usuario u " +
           "JOIN r.equipo e")
    List<Object[]> findReportesConDetalles();

    // Consulta personalizada para actualizar el estado de un reporte
    @Query("UPDATE Reporte r SET r.estado = :estado WHERE r.idReporte = :idReporte")
    void updateEstadoReporte(@Param("estado") String estado, @Param("idReporte") int idReporte);
}
