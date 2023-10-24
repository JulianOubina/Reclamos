package api_reclamos_spring.model.dto;

import java.util.List;

public class UnidadDTO {

	private UsuarioDTO dueño;
	private List<UsuarioDTO> inquilinos;
	private EdificioDTO edificio;
	private List<ReclamoUnidadDTO> reclamos;

	public UnidadDTO() {
	}

	public UnidadDTO(UsuarioDTO dueño, List<UsuarioDTO> inquilinos, EdificioDTO edificio, List<ReclamoUnidadDTO> reclamos) {
		this.dueño = dueño;
		this.inquilinos = inquilinos;
		this.edificio = edificio;
		this.reclamos = reclamos;
	}

	public UsuarioDTO getDueño() {
		return dueño;
	}

	public void setDueño(UsuarioDTO dueño) {
		this.dueño = dueño;
	}

	public List<UsuarioDTO> getInquilinos() {
		return inquilinos;
	}

	public void setInquilinos(List<UsuarioDTO> inquilinos) {
		this.inquilinos = inquilinos;
	}

	public EdificioDTO getEdificio() {
		return edificio;
	}

	public void setEdificio(EdificioDTO edificio) {
		this.edificio = edificio;
	}

	public List<ReclamoUnidadDTO> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<ReclamoUnidadDTO> reclamos) {
		this.reclamos = reclamos;
	}

	

}
