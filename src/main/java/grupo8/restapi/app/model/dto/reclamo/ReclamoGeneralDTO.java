package grupo8.restapi.app.model.dto.reclamo;

import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import grupo8.restapi.app.model.dto.usuarios.UsuarioDTO;

import java.util.Date;

public class ReclamoGeneralDTO {
    private Date fecha;
    private String descripcion;
    private Long idEdificio;
    private Long idUsuario;
    private EstadoReclamoDTO estadoReclamo;
    private String lugar;

    public ReclamoGeneralDTO() {
    }

    public ReclamoGeneralDTO(Date fecha, String descripcion, Long idEdificio, Long usuario, EstadoReclamoDTO estadoReclamo, String lugar) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idEdificio = idEdificio;
        this.idUsuario = usuario;
        this.estadoReclamo = estadoReclamo;
        this.lugar = lugar;
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

    public String getLugar() {
        return lugar;
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

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "ReclamoGeneralDTO{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", edificio=" + idEdificio +
                ", usuario=" + idUsuario +
                ", estadoReclamo=" + estadoReclamo +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
