package co.edu.eu.service;

import co.edu.eu.entity.Equipo;
import java.util.List;

public interface IEquipoService {
    List<Equipo> getAllEquipos();
    Equipo getEquipoById(int id);
    Equipo saveEquipo(Equipo equipo);
    Equipo updateEquipo(Equipo equipo);
    void deleteEquipo(int id);

    // Método para actualizar el id_sala de un equipo dado su id_equipo
    void updateSalaByEquipoId(int idSala, int idEquipo);
    
    void updateEquipoDetails(int idSala, String nombre, String tipo, int idEquipo);
}
