package grupo8.restapi.app.model.dto.reclamo;

import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import grupo8.restapi.app.model.dto.unidad.UnidadDTO;
import grupo8.restapi.app.model.dto.usuarios.UsuarioDTO;

import java.util.Date;

public class ReclamoUnidadDTO {
    private Date fecha;
    private String descripcion;
    private Long idEdificio;
    private Long idUsuario;
    private EstadoReclamoDTO estadoReclamo;
    private UnidadDTO unidad;

    public ReclamoUnidadDTO() {
    }

    public ReclamoUnidadDTO(Date fecha, String descripcion, Long edificio, Long usuario, EstadoReclamoDTO estadoReclamo, UnidadDTO unidad) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idEdificio = edificio;
        this.idUsuario = usuario;
        this.estadoReclamo = estadoReclamo;
        this.unidad = unidad;
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

    public EstadoReclamoDTO getEstadoReclamo() {
        return estadoReclamo;
    }

    public UnidadDTO getUnidad() {
        return unidad;
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

    public void setEstadoReclamo(EstadoReclamoDTO estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public void setUnidad(UnidadDTO unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "ReclamoUnidadDTO{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", edificio=" + idEdificio +
                ", usuario=" + idUsuario +
                ", estadoReclamo=" + estadoReclamo +
                ", unidad=" + unidad +
                '}';
    }
}
