package api_reclamos_spring.model.entity;

public class ReclamoEdificioDTO extends ReclamoDTO{
	private EdificioDTO edificio;
	
	public ReclamoEdificioDTO(String titulo, String comentario, EdificioDTO edificio, UsuarioDTO creador) {
        super();
        this.setTitulo(titulo);
        this.setComentario(comentario);
        this.edificio = edificio;
        this.setCreador(creador);
    }

	public EdificioDTO getEdificio() {
		return edificio;
	}

	public void setEdificio(EdificioDTO edificio) {
		this.edificio = edificio;
	}
}
