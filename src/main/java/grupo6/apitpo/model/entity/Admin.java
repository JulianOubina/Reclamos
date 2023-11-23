package grupo6.apitpo.model.entity;


import jakarta.persistence.Entity;

@Entity
public class Admin extends Usuario {
    public Admin() {

    }
    public Admin(String nombre, String apellido, String nombreUsuario, String contraseña, Integer telefono, String direcion) {
        super(nombre, apellido, nombreUsuario, contraseña, telefono, direcion);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono=" + telefono +
                ", direcion='" + direcion + '\'' +
                '}';
    }
}