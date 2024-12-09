package co.edu.eu.service;

import co.edu.eu.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int id);
    Usuario saveUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    void deleteUsuario(int id);
}
