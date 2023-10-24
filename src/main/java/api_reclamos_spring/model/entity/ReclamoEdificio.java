package api_reclamos_spring.model.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamoEdificio")
public class ReclamoEdificio extends Reclamo{
	private String descripcion; 
	
	public ReclamoEdificio() {
    }
	
	public ReclamoEdificio(String descripcion, Estado estado, String titulo) {
        super(titulo, descripcion, estado, imagen);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ReclamoEdificio [descripcion=" + descripcion + "]";
	}

	
}