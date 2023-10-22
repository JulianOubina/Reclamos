package api_reclamos_spring.model.entity;


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
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
	//private foto BLOB;
	
    public ReclamoEdificio(String titulo, String comentario, Edificio edificio, Usuario creador) {
        super();
        this.setTitulo(titulo);
        this.setComentario(comentario);
        this.edificio = edificio;
        this.setCreador(creador);
    }

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "ReclamoEdificio [edificio=" + edificio + "]";
	}
}