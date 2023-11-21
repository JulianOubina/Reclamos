package api_reclamos_spring.model.dto;

public class EdificioDTO {
	private int id;
	private String calle;
	private int numero;

	private String ciudad;
	public EdificioDTO() {
	}

	public EdificioDTO(int id, String calle, int numero, String ciudad) {
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}