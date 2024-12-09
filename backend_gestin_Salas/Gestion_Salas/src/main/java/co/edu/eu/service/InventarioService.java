package co.edu.eu.service;

import co.edu.eu.entity.Inventario;
import co.edu.eu.repositoryDAO.IInventarioDAO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioService implements IInventarioService {

    private final IInventarioDAO inventarioDAO;

    // Inyección por constructor
    public InventarioService(IInventarioDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }

    @Override
    public Inventario saveInventario(Inventario inventario) {
        return inventarioDAO.save(inventario);
    }

    @Override
    public List<Inventario> getAllInventarios() {
        return inventarioDAO.findAll();
    }

    @Override
    public Inventario getInventarioById(int id) {
        return inventarioDAO.findById(id);
    }

    @Override
    public void deleteInventarioById(int id) {
        inventarioDAO.deleteById(id);
    }

    @Override
    public List<Object[]> getEquiposConDispositivos() {
        return inventarioDAO.findEquiposConDispositivos();  // Llama al DAO para obtener la consulta personalizada
    }
}
