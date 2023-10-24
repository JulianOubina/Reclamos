package api_reclamos_spring.model.dto;

public class ReclamoUnidadDTO extends ReclamoDTO{
	private UnidadDTO unidad;
	
	public ReclamoUnidadDTO(String titulo, String comentario, UnidadDTO unidad, UsuarioDTO creador) {
        super();
        this.setTitulo(titulo);
        this.setComentario(comentario);
        this.unidad = unidad;
        this.setCreador(creador);
    }

	public UnidadDTO getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadDTO unidad) {
		this.unidad = unidad;
	}
}