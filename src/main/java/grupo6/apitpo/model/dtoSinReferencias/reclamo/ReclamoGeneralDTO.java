package grupo6.apitpo.model.dtoSinReferencias.reclamo;

import java.util.Date;

public class ReclamoGeneralDTO {
    private Integer idReclamo;
    private Date fecha;
    private String descripcion;
    private String edificio;
    private String usuario;
    private String lugar;
    private String estado;
    private String mensaje;

    public ReclamoGeneralDTO() {
    }

    public ReclamoGeneralDTO(Integer idReclamo, Date fecha, String descripcion, String idEdificio, String usuario, String lugar) {
        this.idReclamo = idReclamo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.edificio = idEdificio;
        this.usuario = usuario;
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIdEdificio() {
        return edificio;
    }

    public String getUsuario() {
        return usuario;
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

    public void setIdEdificio(String idEdificio) {
        this.edificio = idEdificio;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
                ", edificio=" + edificio +
                ", usuario=" + usuario +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
