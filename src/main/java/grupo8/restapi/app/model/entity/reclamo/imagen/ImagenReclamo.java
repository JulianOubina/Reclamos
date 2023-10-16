package grupo8.restapi.app.model.entity.reclamo.imagen;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class ImagenReclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] datosImagen;
    @ManyToOne
    @JoinColumn(name = "reclamo_id")
    private Reclamo reclamo;

    public ImagenReclamo() {
    }

    public ImagenReclamo(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public ImagenReclamo(byte[] datosImagen, Reclamo reclamo) {
        this.datosImagen = datosImagen;
        this.reclamo = reclamo;
    }
    public Long getId() {
        return id;
    }

    public byte[] getDatosImagen() {
        return datosImagen;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
    @Override
    public String toString() {
        return "Imagen [id=" + id + " de reclamoId="+ reclamo.getIdReclamo() +", datosImagen=" + Arrays.toString(datosImagen) + "]";
    }

}
