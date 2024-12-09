package co.edu.eu.repositoryDAO;

import org.springframework.stereotype.Repository;
import co.edu.eu.entity.Usuario;
import co.edu.eu.repositoryJPA.IUsuarioJPA;
import java.util.List;

@Repository
public class UsuarioDAO implements IUsuarioDAO {

    private final IUsuarioJPA usuarioJPA;

    // Inyección por constructor
    public UsuarioDAO(IUsuarioJPA usuarioJPA) {
        this.usuarioJPA = usuarioJPA;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioJPA.findAll();
    }

    @Override
    public Usuario findById(int id) {
        return usuarioJPA.findById(id).orElse(null);  // Retorna null si no se encuentra
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioJPA.save(usuario);
    }

    @Override
    public void deleteById(int id) {
        usuarioJPA.deleteById(id);
    }

    // Aquí puedes agregar otros métodos específicos si es necesario
}
