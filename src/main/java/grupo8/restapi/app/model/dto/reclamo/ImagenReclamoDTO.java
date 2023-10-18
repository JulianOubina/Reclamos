package grupo8.restapi.app.model.dto.reclamo;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;

public class ImagenReclamoDTO {
    private byte[] datosImagen;
    private Long idReclamo;

    public ImagenReclamoDTO() {
    }

    public ImagenReclamoDTO(byte[] datosImagen, Long idReclamo) {
        this.datosImagen = datosImagen;
        this.idReclamo = idReclamo;
    }

    public byte[] datosImagen() {
        return datosImagen;
    }

    public Long reclamo() {
        return idReclamo;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public void setReclamo(Long idReclamo) {
        this.idReclamo = idReclamo;
    }
}
