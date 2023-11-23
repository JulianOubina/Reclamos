package grupo6.apitpo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Inquilino extends Usuario {
    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;

    public Inquilino(String nombre, String apellido, String nombreUsuario, String contraseña, Integer telefono, String direcion, Unidad unidad) {
        super(nombre, apellido, nombreUsuario, contraseña, telefono, direcion);
        this.unidad = unidad;
    }

    public Inquilino(String nombre, String apellido, String nombreUsuario, String contraseña, Integer telefono, String direcion) {
        super(nombre, apellido, nombreUsuario, contraseña, telefono, direcion);
    }

    public Inquilino() {

    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "unidad=" + unidad +
                ", idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono=" + telefono +
                ", direcion='" + direcion + '\'' +
                '}';
    }
}
