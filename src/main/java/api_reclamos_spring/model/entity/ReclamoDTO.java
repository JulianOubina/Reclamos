package api_reclamos_spring.model.entity;

public class ReclamoDTO {
	private String titulo;
	private String comentario;
	private UsuarioDTO creador;
	
	public ReclamoDTO() {
    	super();
    }
    
	public ReclamoDTO(String titulo, String comentario, UsuarioDTO creador) {
		this.titulo = titulo;
		this.comentario = comentario;
		this.creador = creador;
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

	public UsuarioDTO getCreador() {
		return creador;
	}

	public void setCreador(UsuarioDTO creador) {
		this.creador = creador;
	}
	
	
	
}
