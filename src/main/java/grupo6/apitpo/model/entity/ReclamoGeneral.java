package grupo6.apitpo.model.entity;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class ReclamoGeneral extends Reclamo {
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

}
