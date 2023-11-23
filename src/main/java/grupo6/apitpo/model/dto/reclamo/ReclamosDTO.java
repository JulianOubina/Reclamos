package grupo6.apitpo.model.dto.reclamo;

import java.util.Date;

public class ReclamosDTO {
    private Integer idReclamo;
    private String tipo;
    private Date fecha;
    private String descripcion;
    private Integer idEdificio;
    private Integer idUsuario;
    private String lugar;
    private String estado;
    private String mensaje;


    public ReclamosDTO() {
    }

    public ReclamosDTO(Integer idReclamo,Date fecha, String descripcion, Integer idEdificio, Integer idUsuario, String lugar, String estado, String mensaje) {
        this.idReclamo = idReclamo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idEdificio = idEdificio;
        this.idUsuario = idUsuario;
        this.lugar = lugar;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
