package grupo8.restapi.app.model.entity.reclamo;

import grupo8.restapi.app.model.entity.reclamo.estado.EstadoReclamo;
import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ReclamoUnidad extends Reclamo {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_unidad")
    private Unidad unidad;

    public ReclamoUnidad(String descripcion, List<ImagenReclamo> imagen, EstadoReclamo estado) {
        super(descripcion, imagen, estado);
    }

    public ReclamoUnidad (){
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "ReclamoUnidad{" +
                "idUnidad=" + unidad.getIdUnidad() +
                ", idReclamo=" + idReclamo +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", Edificio=" + Edificio.getIdEdificio() +
                ", usuario=" + usuario.getIdUsuario() +
                ", estado='" + estado + '\'' +
                '}';
    }
}
