package grupo6.apitpo.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Dueno extends Usuario {
    @OneToMany(mappedBy = "dueño", cascade = CascadeType.PERSIST)
    private List<Unidad> unidades = new ArrayList<Unidad>();

    public Dueno() {

    }
    public Dueno(String nombre, String apellido, String nombreUsuario, String contraseña, Integer telefono, String direccion) {
        super(nombre, apellido, nombreUsuario, contraseña, telefono, direccion);
    }
    public Dueno(String nombre, String apellido, String nombreUsuario, String contraseña, Integer telefono, String direccion, List<Unidad> unidades) {
        super(nombre, apellido, nombreUsuario, contraseña, telefono, direccion);
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
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

