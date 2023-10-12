package grupo8.restapi.app.model.entity.usuarios;


import jakarta.persistence.Entity;

@Entity
public class Admin extends Usuario {
    public Admin() {

    }
    public Admin(String nombre, String nombreUs, String contraseña, int telefono, String email, String direcion) {
        super(nombre, nombreUs, contraseña, telefono, email, direcion);
    }

    @Override
    public String toString() {
        return "Admin{" +
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