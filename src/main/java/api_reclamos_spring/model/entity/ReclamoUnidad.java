package api_reclamos_spring.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamoUnidad")
public class ReclamoUnidad extends Reclamo {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;
    
    private String descripcion;

    public ReclamoUnidad(String titulo, String comentario, String descripcion, Estado estado) {
        super(titulo, comentario, estado);
		this.descripcion = descripcion;
    }

    public ReclamoUnidad (){
    }

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
