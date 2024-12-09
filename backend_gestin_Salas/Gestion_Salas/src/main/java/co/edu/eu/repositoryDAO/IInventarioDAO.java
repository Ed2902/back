package co.edu.eu.repositoryDAO;

import co.edu.eu.entity.Inventario;
import java.util.List;

public interface IInventarioDAO {

    // Operaciones estándar (guardar, encontrar, eliminar)
    Inventario save(Inventario inventario);
    List<Inventario> findAll();
    Inventario findById(int id);
    void deleteById(int id);

    // Consulta personalizada
    List<Object[]> findEquiposConDispositivos();
}
