package api_reclamos_spring.model.entity;

public class EdificioDTO {

	private String calle;
	private int numero;

	public EdificioDTO() {
	}

	public EdificioDTO(String calle, int numero) {
		this.calle = calle;
		this.numero = numero;
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