package api_reclamos_spring.model.entity;

public class UsuarioDTO {
	private String nombre_usuario;
	private String contraseña;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(String nombre_usuario, String contraseña) {
		super();
		
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
