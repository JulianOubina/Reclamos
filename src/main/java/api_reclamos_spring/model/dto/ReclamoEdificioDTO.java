package api_reclamos_spring.model.dto;

import java.util.Date;

public class ReclamoEdificioDTO extends ReclamoDTO{
	private int id;
	private String titulo;
	private String comentario;
	private Date fecha;
	private int idUnidad;
	private int idEdificio;
	private String estado;

	public ReclamoEdificioDTO(int id, String titulo, String comentario, Date fecha, int idEdificio, int idUnidad) {
        this.id = id;
        this.titulo = titulo;
        this.comentario = comentario;
		this.fecha = fecha;
		this.idEdificio = idEdificio;
		this.idUnidad = idUnidad;
    }

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String getTitulo() {
		return titulo;
	}

	@Override
	public String getComentario() {
		return comentario;
	}

	@Override
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public int getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
