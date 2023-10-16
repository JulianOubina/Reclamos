package grupo8.restapi.app.model.entity.reclamo;

import grupo8.restapi.app.model.entity.reclamo.estado.EstadoReclamo;
import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class ReclamoGeneral extends Reclamo{
    private String lugar;

    public ReclamoGeneral(String descripcion, List<ImagenReclamo> imagen, EstadoReclamo estado) {
        super(descripcion, imagen, estado);
    }

    public ReclamoGeneral(String descripcion, List<ImagenReclamo> imagen, EstadoReclamo estado, String lugar) {
        super(descripcion, imagen, estado);
        this.lugar = lugar;
    }

    public ReclamoGeneral() {
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "ReclamoGeneral{" +
                "lugar='" + lugar + '\'' +
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
