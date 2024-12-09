package co.edu.eu.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the usuarios database table.
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private int idUsuario;

    // Validación con expresión regular personalizada para el correo
    @NotBlank(message = "El correo no puede estar vacío")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo no tiene un formato válido") // Expresión regular personalizada para el correo
    private String correo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_creacion")
    private Date fechaCreacion;

    // Validación para el nombre con expresión regular
    @NotBlank(message = "El nombre no puede estar vacío")
    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú ]+$", message = "El nombre solo puede contener letras y espacios") // Expresión regular personalizada para el nombre
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    // Validación para la contraseña (mínimo 8 caracteres, al menos una mayúscula, una minúscula y un número)
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$", message = "La contraseña debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas y números")
    private String password;

    private String tipo;

    // Bi-directional many-to-one association to Reporte
    @OneToMany(mappedBy="usuario")
    private List<Reporte> reportes;

    public Usuario() {
    }

    // Getters y setters

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Reporte> getReportes() {
        return this.reportes;
    }

    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    // Método auxiliar para agregar un reporte
    public Reporte addReporte(Reporte reporte) {
        getReportes().add(reporte);
        reporte.setUsuario(this);
        return reporte;
    }

    // Método auxiliar para eliminar un reporte
    public Reporte removeReporte(Reporte reporte) {
        getReportes().remove(reporte);
        reporte.setUsuario(null);
        return reporte;
    }
}
