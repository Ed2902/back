package co.edu.eu.repositoryJPA;

import co.edu.eu.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaJPA extends JpaRepository<Sala, Integer> {

    
}
