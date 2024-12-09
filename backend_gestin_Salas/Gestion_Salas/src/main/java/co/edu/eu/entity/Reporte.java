package co.edu.eu.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

/**
 * The persistent class for the reportes database table.
 */
@Entity
@Table(name="reportes")
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_reporte")
    private int idReporte;

    @NotNull(message = "La descripción no puede estar vacía")
    @Size(max = 500, message = "La descripción no puede tener más de 500 caracteres")
    @Lob
    private String descripcion;

    @NotNull(message = "El estado no puede estar vacío")
    @Size(max = 50, message = "El estado no puede tener más de 50 caracteres")
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_reporte")
    private Date fechaReporte;

    //bi-directional many-to-one association to Usuario
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    //bi-directional many-to-one association to Equipo
    @ManyToOne
    @JoinColumn(name="id_equipo")
    private Equipo equipo;

    public Reporte() {}

    // Getters y Setters

    public int getIdReporte() {
        return this.idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaReporte() {
        return this.fechaReporte;
    }

    public void setFechaReporte(Date fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
