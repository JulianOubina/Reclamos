package grupo8.restapi.app.model.entity.usuarios;

import grupo8.restapi.app.model.entity.unidad.Unidad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Dueno extends Usuario {
    @OneToMany(mappedBy = "dueño", cascade = CascadeType.PERSIST)
    private List<Unidad> unidades = new ArrayList<Unidad>();

    public Dueno() {    }
    public Dueno(String nombre, String nombreUs, String contraseña, int telefono, String email, String direcion) {
        super(nombre, nombreUs, contraseña, telefono, email, direcion);
    }
    public Dueno(String nombre, String nombreUs, String contraseña, int telefono, String email, String direcion, List<Unidad> unidades) {
        super(nombre, nombreUs, contraseña, telefono, email, direcion);
        this.unidades = unidades;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }
    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Dueno{" +
                //"unidades=" + unidades +
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

