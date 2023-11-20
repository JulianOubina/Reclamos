package api_reclamos_spring.model.dto;

import java.util.List;

public class UnidadDTO {

	private int id;
	private int idDueno;
	private int piso;
	private String departamento;
	private String estado;
	private int idEdificio;

	public UnidadDTO() {
	}

	public UnidadDTO(int idDueno, int piso, String departamento, String estado, int idEdificio) {
		this.idDueno = idDueno;
		this.piso = piso;
		this.departamento = departamento;
		this.estado = estado;
		this.idEdificio = idEdificio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDueno() {
		return idDueno;
	}

	public void setIdDueno(int idDueno) {
		this.idDueno = idDueno;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}
}
