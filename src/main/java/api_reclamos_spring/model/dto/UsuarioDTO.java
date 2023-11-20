package api_reclamos_spring.model.dto;

import api_reclamos_spring.model.entity.Usuario;

public class UsuarioDTO {
	private int id;
	private String nombreUsuario;
	private String contraseña;
	private Usuario.Tipo tipo;

	public UsuarioDTO(){
		super();
	}

	public UsuarioDTO(int id, String nombreUsuario, String contraseña, Usuario.Tipo tipo) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
