package api_reclamos_spring.model.dto;

import java.util.Date;

public class ReclamoUnidadDTO extends ReclamoDTO{

	private int id;
	private String titulo;
	private String descripcion;
	private Date fecha;
	private int idEdificio;
	private int idUsuario;
	private int idUnidad;
	private String estado;

	public ReclamoUnidadDTO() {
	}
	public ReclamoUnidadDTO(Date fecha, String descripcion, int idEdificio, int idUsuario, int idUnidad, String estado, String mensaje) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.idEdificio = idEdificio;
		this.idUsuario = idUsuario;
		this.idUnidad = idUnidad;
		this.estado = estado;
	}
}