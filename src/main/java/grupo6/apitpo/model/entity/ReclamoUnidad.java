package grupo6.apitpo.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ReclamoUnidad extends Reclamo {
    @ManyToOne
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

}
