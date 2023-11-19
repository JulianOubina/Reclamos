package api_reclamos_spring.model.dto;

import api_reclamos_spring.model.entity.Usuario;

public class UsuarioDTO {
	private String nombreUsuario;
	private String contraseña;
	private Usuario.Tipo tipo;

	public UsuarioDTO(){
		super();
	}

	public UsuarioDTO(String nombreUsuario, String contraseña, Usuario.Tipo tipo) {
		super();
		
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}
	
	public String getNombre_usuario() {
		return nombreUsuario;
	}

	public void setNombre_usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Usuario.Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Usuario.Tipo tipo) {
		this.tipo = tipo;
	}
}
