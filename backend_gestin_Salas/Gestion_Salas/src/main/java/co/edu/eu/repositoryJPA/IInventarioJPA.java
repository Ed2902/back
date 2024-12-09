package co.edu.eu.repositoryJPA;

import co.edu.eu.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IInventarioJPA extends JpaRepository<Inventario, Integer> {

    // Consulta personalizada con GROUP_CONCAT
    @Query(value = "SELECT equipos.id_equipo, equipos.nombre AS nombre_equipo, GROUP_CONCAT(inventario.dispositivo) AS dispositivos " +
                   "FROM inventario " +
                   "JOIN equipos ON inventario.id_equipo = equipos.id_equipo " +
                   "GROUP BY equipos.id_equipo, equipos.nombre " +
                   "ORDER BY equipos.id_equipo", nativeQuery = true)
    List<Object[]> findEquiposConDispositivos();
}
