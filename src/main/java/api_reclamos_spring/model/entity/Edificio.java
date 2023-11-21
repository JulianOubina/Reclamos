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
	private String ciudad;
	
	@OneToOne
	@JoinColumn(name = "dueño_id")
	private Usuario dueño;
	
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
	private List<Unidad> unidades = new ArrayList<Unidad>();
	
	public Edificio() {
		super();
	}

	public Edificio(String calle, int numero, String ciudad, Usuario dueño, List<Unidad> unidades) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.dueño = dueño;
		this.unidades = unidades;
	}
	public Edificio(String calle, int numero, String ciudad, Usuario dueño) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.dueño = dueño;
	}

	public Edificio(String calle, int numero, String ciudad) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", dueño="
				+ dueño + ", unidades=" + unidades + "]";
	}
}
