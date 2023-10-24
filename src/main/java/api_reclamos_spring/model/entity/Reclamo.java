package api_reclamos_spring.model.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Reclamo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
   
    public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private String comentario;

    @OneToOne
    @JoinColumn(name = "dueño_id")
    private Usuario creador;
    
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    protected Date fecha;
    protected String descripcion;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    
    public enum Estado{
    	CERRADO,
    	ABIERTO
    }
    
    private Estado estado;
    
    public Reclamo() {
    	super();
    }
    
	public Reclamo(String titulo, String comentario, Usuario creador, Estado estado) {
		super();
		this.titulo = titulo;
		this.comentario = comentario;
		this.estado = estado;
		
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
