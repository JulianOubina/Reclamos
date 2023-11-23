package grupo6.apitpo.model.dto.reclamo;

public class ImagenReclamoDTO{
    private Integer id;
    private Integer idReclamo;

    public ImagenReclamoDTO() {
    }

    public ImagenReclamoDTO(Integer id, Integer idReclamo) {
        this.id = id;
        this.idReclamo = idReclamo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Integer idReclamo) {
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
