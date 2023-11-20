package api_reclamos_spring.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReclamoEdificio extends Reclamo{
	private String descripcion; 
	
	public ReclamoEdificio() {
    }
	
	public ReclamoEdificio(String titulo, String comentario, Estado estado, String descripcion) {
        super(titulo, comentario, estado);
        this.descripcion = descripcion;
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