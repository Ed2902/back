package co.edu.eu.service;

import org.springframework.stereotype.Service;
import co.edu.eu.entity.Equipo;
import co.edu.eu.repositoryDAO.IEquipoDAO;
import java.util.List;

@Service
public class EquipoService implements IEquipoService {

    private final IEquipoDAO equipoDAO;

    // Inyección por constructor
    public EquipoService(IEquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }

    @Override
    public List<Equipo> getAllEquipos() {
        return equipoDAO.findAll();
    }

    @Override
    public Equipo getEquipoById(int id) {
        return equipoDAO.findById(id);
    }

    @Override
    public Equipo saveEquipo(Equipo equipo) {
        return equipoDAO.save(equipo);
    }

    @Override
    public Equipo updateEquipo(Equipo equipo) {
        return equipoDAO.save(equipo);
    }

    @Override
    public void deleteEquipo(int id) {
        equipoDAO.deleteById(id);
    }

    @Override
    public void updateSalaByEquipoId(int idSala, int idEquipo) {
        equipoDAO.updateSalaByEquipoId(idSala, idEquipo);  // Llama al DAO para realizar la actualización
    }

    @Override
    public void updateEquipoDetails(int idSala, String nombre, String tipo, int idEquipo) {
        equipoDAO.updateEquipoDetails(idSala, nombre, tipo, idEquipo);  // Llama al DAO para realizar la actualización de los detalles
    }
}
