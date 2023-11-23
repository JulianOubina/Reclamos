package grupo6.apitpo.model.dtoSinReferencias.reclamo;

import java.util.Date;

public class ReclamosDTOSinRef {
    private Integer idReclamo;
    private String tipo;
    private Date fecha;
    private String descripcion;
    private String edificio;
    private String usuario;
    private String lugar;
    private String estado;
    private String mensaje;


    public ReclamosDTOSinRef() {
    }

    public ReclamosDTOSinRef(Integer idReclamo, Date fecha, String descripcion, String idEdificio, String idUsuario, String lugar, String estado, String mensaje) {
        this.idReclamo = idReclamo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.edificio = idEdificio;
        this.usuario = idUsuario;
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
}
