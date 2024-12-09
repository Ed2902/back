package co.edu.eu.repositoryDAO;

import java.util.List;
import co.edu.eu.entity.Equipo;

public interface IEquipoDAO {
    List<Equipo> findAll();
    Equipo findById(int id);
    Equipo save(Equipo equipo);
    void deleteById(int id);

    // Consulta personalizada para actualizar el id_sala de un equipo por id_equipo
    void updateSalaByEquipoId(int idSala, int idEquipo);

    // Método para actualizar los detalles completos del equipo
    void updateEquipoDetails(int idSala, String nombre, String tipo, int idEquipo);
}
