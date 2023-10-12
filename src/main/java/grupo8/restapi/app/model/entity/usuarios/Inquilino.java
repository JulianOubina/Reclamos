package grupo8.restapi.app.model.entity.usuarios;

import grupo8.restapi.app.model.entity.unidad.Unidad;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Inquilino extends Usuario {
    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;

    public Inquilino(String nombre, String nombreUs, String contraseña, int telefono, String email, String direcion, Unidad unidad) {
        super(nombre, nombreUs, contraseña, telefono, email, direcion);
        this.unidad = unidad;
    }

    public Inquilino(String nombre, String nombreUs, String contraseña, int telefono, String email, String direcion) {
        super(nombre, nombreUs, contraseña, telefono, email, direcion);
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
                ", nombreUs='" + nombreUs + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", direcion='" + direcion + '\'' +
                '}';
    }
}
