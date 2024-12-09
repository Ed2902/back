package co.edu.eu.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the equipos database table.
 * 
 */
@Entity
@Table(name="equipos")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_equipo")
	private int idEquipo;

	@NotNull(message = "El nombre del equipo no puede ser nulo")
	@Size(min = 3, max = 50, message = "El nombre del equipo debe tener entre 3 y 50 caracteres")
	private String nombre;

	@NotNull(message = "El tipo del equipo no puede ser nulo")
	@Size(min = 3, max = 50, message = "El tipo del equipo debe tener entre 3 y 50 caracteres")
	private String tipo;

	// Bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="id_sala")
	@JsonIgnore
	@NotNull(message = "La sala no puede ser nula")
	private Sala sala;

	// Bi-directional many-to-one association to Inventario
	@OneToMany(mappedBy="equipo")
	@JsonIgnore
	private List<Inventario> inventarios;

	// Bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="equipo")
	@JsonIgnore
	private List<Reporte> reportes;

	// Constructor
	public Equipo() {
	}

	public int getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Inventario> getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public Inventario addInventario(Inventario inventario) {
		getInventarios().add(inventario);
		inventario.setEquipo(this);
		return inventario;
	}

	public Inventario removeInventario(Inventario inventario) {
		getInventarios().remove(inventario);
		inventario.setEquipo(null);
		return inventario;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setEquipo(this);
		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setEquipo(null);
		return reporte;
	}
}
