package co.edu.eu.repositoryDAO;

import co.edu.eu.entity.Inventario;
import co.edu.eu.repositoryJPA.IInventarioJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public class InventarioDAO implements IInventarioDAO {

    private final IInventarioJPA inventarioJPA;

    // Inyección por constructor
    public InventarioDAO(IInventarioJPA inventarioJPA) {
        this.inventarioJPA = inventarioJPA;
    }

    @Override
    public Inventario save(Inventario inventario) {
        return inventarioJPA.save(inventario);
    }

    @Override
    public List<Inventario> findAll() {
        return inventarioJPA.findAll();
    }

    @Override
    public Inventario findById(int id) {
        return inventarioJPA.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        inventarioJPA.deleteById(id);
    }

    @Override
    @Transactional
    @Query("SELECT e.idEquipo, e.nombre AS nombreEquipo, GROUP_CONCAT(i.dispositivo) AS dispositivos " +
           "FROM Inventario i " +
           "JOIN i.equipo e " +
           "GROUP BY e.idEquipo, e.nombre " +
           "ORDER BY e.idEquipo")
    public List<Object[]> findEquiposConDispositivos() {
        return inventarioJPA.findEquiposConDispositivos(); // Método que ejecuta la consulta personalizada
    }
}
