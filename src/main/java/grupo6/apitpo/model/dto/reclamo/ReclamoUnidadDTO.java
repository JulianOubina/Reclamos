package grupo6.apitpo.model.dto.reclamo;

import java.util.Date;

public class ReclamoUnidadDTO {
    private Integer idReclamo;
    private Date fecha;
    private String descripcion;
    private Integer idEdificio;
    private Integer idUsuario;
    private Integer idUnidad;
    private String estado;
    private String mensaje;

    public ReclamoUnidadDTO() {
    }

    public ReclamoUnidadDTO(Date fecha, String descripcion, Integer idEdificio, Integer idUsuario, Integer idUnidad, String estado, String mensaje) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idEdificio = idEdificio;
        this.idUsuario = idUsuario;
        this.idUnidad = idUnidad;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getIdEdificio() {
        return idEdificio;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getUnidad() {
        return this.idUnidad;
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Integer getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdEdificio(Integer idEdificio) {
        this.idEdificio = idEdificio;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setUnidad(Integer unidad) {
        this.idUnidad = unidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ReclamoUnidadDTO{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", edificio=" + idEdificio +
                ", usuario=" + idUsuario +
                ", unidad=" + idUnidad +
                '}';
    }
}
