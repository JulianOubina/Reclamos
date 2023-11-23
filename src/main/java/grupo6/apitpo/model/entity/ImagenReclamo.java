package grupo6.apitpo.model.entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class ImagenReclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    public Integer getId() {
        return id;
    }

    public byte[] getDatosImagen() {
        return datosImagen;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setId(Integer id) {
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
