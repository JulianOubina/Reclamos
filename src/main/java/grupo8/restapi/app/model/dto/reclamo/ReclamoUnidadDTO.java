package grupo8.restapi.app.model.dto.reclamo;

import grupo8.restapi.app.model.dto.unidad.UnidadDTO;

import java.util.Date;

public class ReclamoUnidadDTO {
    private Date fecha;
    private String descripcion;
    private Long idEdificio;
    private Long idUsuario;
    private Long idUnidad;
    private String estado;
    private String mensaje;

    public ReclamoUnidadDTO() {
    }

    public ReclamoUnidadDTO(Date fecha, String descripcion, Long idEdificio, Long idUsuario, Long idUnidad, String estado, String mensaje) {
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

    public Long getIdEdificio() {
        return idEdificio;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getUnidad() {
        return this.idUnidad;
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdEdificio(Long idEdificio) {
        this.idEdificio = idEdificio;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setUnidad(Long unidad) {
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
