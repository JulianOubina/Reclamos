package api_reclamos_spring.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreUsuario;
	private String contraseña;
	private String nombre;
	private String apellido;
	private int telefono;
	
	public enum Tipo {
	    ADMINISTRADOR,
	    DUEÑO,
	    INQUILINO
	}
	
	private Tipo tipo;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombreUsuario, String contraseña, String nombre, String apellido, int telefono, Tipo tipo) {
		super();
		
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre_usuario=" + nombreUsuario + ", contraseña=" + contraseña + ", nombre="
				+ nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", tipo=" + tipo + "]";
	}
}

