package co.edu.eu.service;

import co.edu.eu.entity.Sala;
import co.edu.eu.repositoryDAO.ISalaDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService implements ISalaService {

    private final ISalaDAO salaDAO;

    // Inyección por constructor
    public SalaService(ISalaDAO salaDAO) {
        this.salaDAO = salaDAO;
    }

    @Override
    public List<Sala> getAllSalas() {
        return salaDAO.findAll();  // Delegamos la operación a la capa DAO
    }

    @Override
    public Sala getSalaById(int id) {
        return salaDAO.findById(id);  // Delegamos la operación a la capa DAO
    }

    @Override
    public Sala saveSala(Sala sala) {
        return salaDAO.save(sala);  // Delegamos la operación a la capa DAO
    }

    @Override
    public Sala updateSala(Sala sala) {
        return salaDAO.save(sala);  // Delegamos la operación a la capa DAO
    }

    @Override
    public boolean deleteSala(int id) {
        try {
            salaDAO.deleteById(id);  // Delegamos la operación a la capa DAO
            return true;
        } catch (Exception e) {
            return false;  // Si ocurre algún error, retornamos false
        }
    }

    @Override
    public void updateSalaDetails(int capacidad, String nombre, String ubicacion, int idSala) {
        salaDAO.updateSalaDetails(capacidad, nombre, ubicacion, idSala);  // Delegamos la operación a la capa DAO
    }
}
