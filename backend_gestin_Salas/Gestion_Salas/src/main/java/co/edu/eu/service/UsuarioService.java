package co.edu.eu.service;

import org.springframework.stereotype.Service;
import co.edu.eu.entity.Usuario;
import co.edu.eu.repositoryDAO.IUsuarioDAO;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioDAO usuarioDAO;

    // Inyección por constructor
    public UsuarioService(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.findAll();  // Devuelve todos los usuarios
    }

    @Override
    public Usuario getUsuarioById(int id) {
        return usuarioDAO.findById(id);  // Busca un usuario por su ID
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);  // Guarda o actualiza el usuario
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);  // Actualiza el usuario
    }

    @Override
    public void deleteUsuario(int id) {
        usuarioDAO.deleteById(id);  // Elimina el usuario por su ID
    }
}
