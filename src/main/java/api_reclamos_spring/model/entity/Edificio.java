package api_reclamos_spring.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "edificio")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String calle;
	private int numero;
	
	@OneToOne
	@JoinColumn(name = "dueño_id")
	private Usuario dueño;
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	private List<Unidad> unidades = new ArrayList<Unidad>();
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.REMOVE)
	private List<ReclamoEdificio> reclamos = new ArrayList<ReclamoEdificio>();
	
	public Edificio() {
		super();
	}
	
	public Edificio(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}
	
	public Edificio(Usuario dueño, String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.dueño = dueño;
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

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}

	public List<ReclamoEdificio> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<ReclamoEdificio> reclamos) {
		this.reclamos = reclamos;
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", dueño=" + dueño + ", calle=" + calle + ", numero=" + numero + ", unidades="
				+ unidades + ", reclamos=" + reclamos + "]";
	}
}
