package grupo8.restapi.app.model.dto.reclamo;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;

public class ImagenReclamoDTO {
    private byte[] datosImagen;
    private Reclamo reclamo;

    public ImagenReclamoDTO() {
    }

    public ImagenReclamoDTO(byte[] datosImagen, Reclamo reclamo) {
        this.datosImagen = datosImagen;
        this.reclamo = reclamo;
    }

    public byte[] datosImagen() {
        return datosImagen;
    }

    public Reclamo reclamo() {
        return reclamo;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
}
