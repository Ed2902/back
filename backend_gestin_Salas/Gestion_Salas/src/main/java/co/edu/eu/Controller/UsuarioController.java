package co.edu.eu.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.eu.entity.Usuario;
import co.edu.eu.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "usuarios")
public class UsuarioController {

    private final IUsuarioService service;

    // Inyección por constructor
    public UsuarioController(IUsuarioService service) {
        this.service = service;
    }

    // Obtener todos los usuarios
    @GetMapping(value = "/ver-usuarios")
    public List<Usuario> getAllUsuarios() {
        return service.getAllUsuarios();  // Devuelve la lista de usuarios
    }

    // Obtener un usuario por ID
    @GetMapping(value = "/usuario-id")
    public Usuario getUsuarioById(@RequestParam("id") int id) {
        return service.getUsuarioById(id);  // Buscar un usuario por su ID
    }

    // Agregar un nuevo usuario
    @PostMapping(value = "/agregar")
    public ResponseEntity<?> addUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Si hay errores de validación
        }
        Usuario addedUsuario = service.saveUsuario(usuario);  // Guardar el nuevo usuario
        return ResponseEntity.ok(addedUsuario);  // Responder con el usuario agregado
    }

    // Actualizar un usuario existente
    @PutMapping(value = "/actualizar")
    public ResponseEntity<?> updateUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());  // Si hay errores de validación
        }
        Usuario updatedUsuario = service.updateUsuario(usuario);  // Actualizar el usuario
        return ResponseEntity.ok(updatedUsuario);  // Responder con el usuario actualizado
    }

    // Eliminar un usuario por ID
    @DeleteMapping(value = "/eliminar")
    public ResponseEntity<?> deleteUsuario(@RequestParam("id") int id) {
        service.deleteUsuario(id);  // Eliminar el usuario
        return ResponseEntity.ok().build();  // Responder con estado 200 OK
    }
}
