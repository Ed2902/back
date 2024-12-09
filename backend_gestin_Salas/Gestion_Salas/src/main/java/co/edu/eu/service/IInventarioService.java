package co.edu.eu.service;

import co.edu.eu.entity.Inventario;
import java.util.List;

public interface IInventarioService {

    // Operaciones CRUD
    Inventario saveInventario(Inventario inventario);
    List<Inventario> getAllInventarios();
    Inventario getInventarioById(int id);
    void deleteInventarioById(int id);

    // Consulta personalizada
    List<Object[]> getEquiposConDispositivos();
}
