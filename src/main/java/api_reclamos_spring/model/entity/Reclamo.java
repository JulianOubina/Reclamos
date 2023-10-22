package api_reclamos_spring.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public abstract class Reclamo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String comentario;

    @OneToOne
    @JoinColumn(name = "dueño_id")
    private Usuario creador;
    
    public Reclamo() {
    	super();
    }
    
	public Reclamo(int id, String titulo, String comentario, Usuario creador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.comentario = comentario;
		this.creador = creador;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Usuario getCreador() {
		return creador;
	}
	
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	
	
	
}
