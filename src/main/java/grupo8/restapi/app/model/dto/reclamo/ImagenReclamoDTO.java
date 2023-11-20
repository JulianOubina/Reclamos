package grupo8.restapi.app.model.dto.reclamo;

public class ImagenReclamoDTO{
    private Long id;
    private Long idReclamo;

    public ImagenReclamoDTO() {
    }

    public ImagenReclamoDTO(Long id, Long idReclamo) {
        this.id = id;
        this.idReclamo = idReclamo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Long idReclamo) {
        this.idReclamo = idReclamo;
    }

    @Override
    public String toString() {
        return "ImagenReclamoDTO{" +
                "id=" + id +
                ", idReclamo=" + idReclamo +
                '}';
    }
}
