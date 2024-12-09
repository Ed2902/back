package co.edu.eu.repositoryDAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.eu.entity.Equipo;
import co.edu.eu.repositoryJPA.IEquipoJPA;
import java.util.List;

@Repository
public class EquipoDAO implements IEquipoDAO {

    private final IEquipoJPA equipoJPA;

    // Inyección por constructor
    public EquipoDAO(IEquipoJPA equipoJPA) {
        this.equipoJPA = equipoJPA;
    }

    @Override
    public List<Equipo> findAll() {
        return equipoJPA.findAll();
    }

    @Override
    public Equipo findById(int id) {
        return equipoJPA.findById(id).orElse(null);  // Retorna null si no se encuentra
    }

    @Override
    public Equipo save(Equipo equipo) {
        return equipoJPA.save(equipo);
    }

    @Override
    public void deleteById(int id) {
        equipoJPA.deleteById(id);
    }

    @Override
    @Transactional
    public void updateSalaByEquipoId(int idSala, int idEquipo) {
        equipoJPA.updateSalaByEquipoId(idSala, idEquipo);  // Llama a la consulta personalizada
    }

    @Override
    @Transactional
    public void updateEquipoDetails(int idSala, String nombre, String tipo, int idEquipo) {
        equipoJPA.updateEquipoDetails(idSala, nombre, tipo, idEquipo);  // Llama a la consulta personalizada
    }
}
