package grupo6.apitpo.model.dtoSinReferencias.reclamo;

import java.util.Date;

public class ReclamoUnidadDTOSinRef {
    private Integer idReclamo;
    private Date fecha;
    private String descripcion;
    private String edificio;
    private String usuario;
    private String unidad;
    private String estado;
    private String mensaje;

    public ReclamoUnidadDTOSinRef() {
    }

    public ReclamoUnidadDTOSinRef(Date fecha, String descripcion, String idEdificio, String idUsuario, String idUnidad, String estado, String mensaje) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.edificio = idEdificio;
        this.usuario = idUsuario;
        this.unidad = idUnidad;
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

    public String getUnidad() {
        return this.unidad;
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
    public void setUnidad(String unidad) {
        this.unidad = unidad;
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
                ", edificio=" + edificio +
                ", usuario=" + usuario +
                ", unidad=" + unidad +
                '}';
    }
}
