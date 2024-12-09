package co.edu.eu.repositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.eu.entity.Usuario;

public interface IUsuarioJPA extends JpaRepository<Usuario, Integer> {
   
}
