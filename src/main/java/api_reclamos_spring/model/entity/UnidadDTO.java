package api_reclamos_spring.model.entity;

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

	public Usuario getDueño() {
		return dueño;
	}

	public void setDueño(Usuario dueño) {
		this.dueño = dueño;
	}

	public List<Usuario> getInquilinos() {
		return inquilinos;
	}

	public void setInquilinos(List<Usuario> inquilinos) {
		this.inquilinos = inquilinos;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public List<ReclamoUnidad> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<ReclamoUnidad> reclamos) {
		this.reclamos = reclamos;
	}

}
