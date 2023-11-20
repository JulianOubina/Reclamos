package api_reclamos_spring.model.dto;

public class ReclamoDTO {
	private int id;
	private String titulo;
	private String comentario;
	private UsuarioDTO creador;
	
	public ReclamoDTO() {
    	super();
    }
    
	public ReclamoDTO(int id, String titulo, String comentario, UsuarioDTO creador) {
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

	public UsuarioDTO getCreador() {
		return creador;
	}

	public void setCreador(UsuarioDTO creador) {
		this.creador = creador;
	}
	
	
	
}
