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
	
	@OneToOne
	@JoinColumn(name = "dueño_id")
	private Usuario dueño;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id")
	private Edificio edificio;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "inquilinos_id", 
					joinColumns = @JoinColumn(name = "unidad_FK_id"), 
	inverseJoinColumns = @JoinColumn(name = "usuario_FK_id"))
	private List<Usuario> inquilinos = new ArrayList<Usuario>();
	
	
	@OneToMany(mappedBy = "unidad", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<ReclamoUnidad> reclamos = new ArrayList<ReclamoUnidad>();
	
	public enum Estado {
	    DISPONIBLE,
	    NODISPONIBLE,
	}
	
	private Estado estado;
	
	public Unidad() {
		super();
	}
	
	public Unidad(Usuario dueño, Edificio edificio, Estado estado) {
		super();
		this.dueño = dueño;
		this.edificio = edificio;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getDueño() {
		return dueño;
	}

	public void setDueño(Usuario dueño) {
		this.dueño = dueño;
	}

	public List<Usuario> getInquilinos() {
		return inquilinos;
	}

	public void setInquilinos(List<Usuario> inquilinos) {
		this.inquilinos = inquilinos;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	
	public List<ReclamoUnidad> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<ReclamoUnidad> reclamos) {
		this.reclamos = reclamos;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Unidad [id=" + id + ", dueño=" + dueño + ", edificio=" + edificio + ", inquilinos=" + inquilinos
				+ ", reclamos=" + reclamos + ", estado=" + estado + "]";
	}

	
}

