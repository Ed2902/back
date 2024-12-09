package co.edu.eu.service;

import co.edu.eu.entity.Sala;
import java.util.List;

public interface ISalaService {

    List<Sala> getAllSalas();  // Obtener todas las salas

    Sala getSalaById(int id);  // Obtener una sala por ID

    Sala saveSala(Sala sala);  // Guardar una nueva sala

    Sala updateSala(Sala sala);  // Actualizar los datos de una sala

    boolean deleteSala(int id);  // Eliminar una sala por ID

    void updateSalaDetails(int capacidad, String nombre, String ubicacion, int idSala);  // Actualizar detalles de una sala
}
