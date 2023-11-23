package grupo6.apitpo.model.dto.reclamo;

import java.util.Date;

public class ReclamoGeneralDTO {
    private Integer idReclamo;
    private Date fecha;
    private String descripcion;
    private Integer idEdificio;
    private Integer idUsuario;
    private String lugar;
    private String estado;
    private String mensaje;

    public ReclamoGeneralDTO() {
    }

    public ReclamoGeneralDTO(Integer idReclamo, Date fecha, String descripcion, Integer idEdificio, Integer usuario, String lugar) {
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

    public Integer getIdEdificio() {
        return idEdificio;
    }

    public Integer getIdUsuario() {
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
