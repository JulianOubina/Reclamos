package grupo8.restapi.app.model.dto.reclamo;

import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import grupo8.restapi.app.model.dto.usuarios.UsuarioDTO;

import java.util.Date;

public class ReclamoGeneralDTO {
    private Long idReclamo;
    private Date fecha;
    private String descripcion;
    private Long idEdificio;
    private Long idUsuario;
    private String lugar;
    private String estado;
    private String mensaje;

    public ReclamoGeneralDTO() {
    }

    public ReclamoGeneralDTO(Long idReclamo, Date fecha, String descripcion, Long idEdificio, Long usuario, String lugar) {
        this.idReclamo = idReclamo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idEdificio = idEdificio;
        this.idUsuario = usuario;
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

    public String getLugar() {
        return lugar;
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Long getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Long idReclamo) {
        this.idReclamo = idReclamo;
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

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ReclamoGeneralDTO{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", edificio=" + idEdificio +
                ", usuario=" + idUsuario +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
