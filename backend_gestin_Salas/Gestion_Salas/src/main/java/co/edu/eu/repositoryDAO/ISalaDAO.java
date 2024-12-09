package co.edu.eu.repositoryDAO;

import co.edu.eu.entity.Sala;
import java.util.List;

public interface ISalaDAO {
    
    List<Sala> findAll();  // Obtener todas las salas
    
    Sala findById(int id);  // Obtener una sala por ID
    
    Sala save(Sala sala);  // Guardar o actualizar una sala
    
    void deleteById(int id);  // Eliminar una sala por ID
    
    void updateSalaDetails(int capacidad, String nombre, String ubicacion, int idSala);  // Actualizar detalles de la sala
}
