package co.edu.eu.repositoryDAO;

import org.springframework.stereotype.Repository;
import co.edu.eu.entity.Sala;
import co.edu.eu.repositoryJPA.ISalaJPA;
import java.util.List;

@Repository
public class SalaDAO implements ISalaDAO {

    private final ISalaJPA salaJPA;

    // Inyección por constructor
    public SalaDAO(ISalaJPA salaJPA) {
        this.salaJPA = salaJPA;
    }

    @Override
    public List<Sala> findAll() {
        return salaJPA.findAll();
    }

    @Override
    public Sala findById(int id) {
        return salaJPA.findById(id).orElse(null);
    }

    @Override
    public Sala save(Sala sala) {
        return salaJPA.save(sala);
    }

    @Override
    public void deleteById(int id) {
        if (salaJPA.existsById(id)) {
            salaJPA.deleteById(id);  // Utiliza el método de Spring Data para eliminar la sala
        }
    }

    @Override
    public void updateSalaDetails(int capacidad, String nombre, String ubicacion, int idSala) {
        // Aquí no necesitamos hacer nada, ya que la consulta de actualización está en el controlador
    }
}
