package api_reclamos_spring.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "unidad")
public class Unidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int piso;
	private String departamento;
	@ManyToOne
	@JoinColumn(name = "edificio_id")
	private Edificio edificio;
	@OneToOne
	@JoinColumn(name = "inquilino_id")
	private Usuario inquilino;
	
	public enum Estado {
	    DISPONIBLE,
	    NODISPONIBLE,
	}
	
	private Estado estado;
	
	public Unidad() {
		super();
	}
	
	public Unidad(int piso, String departamento, Estado estado) {
		this.piso = piso;
		this.departamento = departamento;
		this.estado = estado;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Usuario getInquilino() {
		return inquilino;
	}

	public void setInquilino(Usuario inquilino) {
		this.inquilino = inquilino;
	}
}

