package co.edu.eu.repositoryDAO;

import java.util.List;
import co.edu.eu.entity.Usuario;

public interface IUsuarioDAO {
    List<Usuario> findAll();
    Usuario findById(int id);
    Usuario save(Usuario usuario);
    void deleteById(int id);
}
