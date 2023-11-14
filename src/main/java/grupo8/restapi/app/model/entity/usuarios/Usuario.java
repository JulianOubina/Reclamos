package grupo8.restapi.app.model.entity.usuarios;


import grupo8.restapi.app.model.entity.reclamo.Reclamo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // todos los hijos en la misma tabla
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING) // agrega la columna tipo_usuario con el tipo de dato String
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long idUsuario;
    protected String nombre;
    protected String nombreUs;
    protected String contraseña;
    protected int telefono;
    protected String email;
    protected String direcion;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    protected List<Reclamo> reclamos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre, String nombreUs, String contraseña, int telefono, String email, String direcion) {
        this.nombre = nombre;
        this.nombreUs = nombreUs;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.email = email;
        this.direcion = direcion;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getContraseña() {
        return contraseña;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", nombreUs='" + nombreUs + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", direcion='" + direcion + '\'' +
                '}';
    }
}
