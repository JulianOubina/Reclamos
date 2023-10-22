package api_reclamos_spring.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamoUnidad")
public class ReclamoUnidad extends Reclamo{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
    @JoinColumn(name = "edificio_id")
    private Unidad unidad;

    public ReclamoUnidad(Unidad unidad, Usuario creador, String titulo, String comentario) {
        super();
        this.unidad = unidad;
        this.setCreador(creador);
        this.setTitulo(titulo);
        this.setComentario(comentario);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "ReclamoUnidad [id=" + id + ", unidad=" + unidad + "]";
	}
    
}
