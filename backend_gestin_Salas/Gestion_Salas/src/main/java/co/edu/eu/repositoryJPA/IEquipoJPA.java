package co.edu.eu.repositoryJPA;

import co.edu.eu.entity.Equipo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IEquipoJPA extends JpaRepository<Equipo, Integer> {

    // Consulta personalizada para actualizar el id_sala por id_equipo
    @Modifying
    @Transactional
    @Query("UPDATE Equipo e SET e.sala.idSala = :idSala WHERE e.idEquipo = :idEquipo")
    void updateSalaByEquipoId(@Param("idSala") int idSala, @Param("idEquipo") int idEquipo);

    // Consulta para actualizar los detalles del equipo
    @Modifying
    @Transactional
    @Query("UPDATE Equipo e SET e.sala.idSala = :idSala, e.nombre = :nombre, e.tipo = :tipo WHERE e.idEquipo = :idEquipo")
    void updateEquipoDetails(@Param("idSala") int idSala, @Param("nombre") String nombre, @Param("tipo") String tipo, @Param("idEquipo") int idEquipo);
}
