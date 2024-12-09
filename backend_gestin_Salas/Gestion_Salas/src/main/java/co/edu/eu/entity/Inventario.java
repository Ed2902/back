package co.edu.eu.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * The persistent class for the inventario database table.
 * 
 */
@Entity
@NamedQuery(name="Inventario.findAll", query="SELECT i FROM Inventario i")
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_inventario")
    private int idInventario;

    // Validación: El dispositivo no puede estar vacío y no debe contener números
    @NotBlank(message = "El dispositivo no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El dispositivo no puede contener números")
    private String dispositivo;

    // bi-directional many-to-one association to Equipo
    @ManyToOne
    @JoinColumn(name="id_equipo")
    @NotNull(message = "El equipo no puede ser nulo")
    private Equipo equipo;

    public Inventario() {
    }

    public int getIdInventario() {
        return this.idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getDispositivo() {
        return this.dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
