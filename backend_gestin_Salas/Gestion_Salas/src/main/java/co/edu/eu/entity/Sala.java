package co.edu.eu.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

/**
 * The persistent class for the salas database table.
 * 
 */
@Entity
@Table(name="salas")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_sala")
    private int idSala;

    @Min(value = 1, message = "La capacidad debe ser mayor que 0")
    private int capacidad;

    @NotNull(message = "El nombre de la sala no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre de la sala debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "La ubicación de la sala no puede ser nula")
    @Size(min = 3, max = 255, message = "La ubicación de la sala debe tener entre 3 y 255 caracteres")
    private String ubicacion;

    //bi-directional many-to-one association to Equipo
    @OneToMany(mappedBy="sala")
    private List<Equipo> equipos;

    public Sala() {}

    public int getIdSala() {
        return this.idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Equipo> getEquipos() {
        return this.equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Equipo addEquipo(Equipo equipo) {
        getEquipos().add(equipo);
        equipo.setSala(this);
        return equipo;
    }

    public Equipo removeEquipo(Equipo equipo) {
        getEquipos().remove(equipo);
        equipo.setSala(null);
        return equipo;
    }
}
