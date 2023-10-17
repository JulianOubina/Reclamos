package grupo8.restapi.app.model.dto.reclamo;

import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import grupo8.restapi.app.model.dto.unidad.UnidadDTO;
import grupo8.restapi.app.model.dto.usuarios.UsuarioDTO;

import java.util.Date;

public class ReclamoUnidadDTO {
    private Date fecha;
    private String descripcion;
    private EdificioDTO edificio;
    private UsuarioDTO usuario;
    private EstadoReclamoDTO estadoReclamo;
    private UnidadDTO unidad;

    public ReclamoUnidadDTO() {
    }

    public ReclamoUnidadDTO(Date fecha, String descripcion, EdificioDTO edificio, UsuarioDTO usuario, EstadoReclamoDTO estadoReclamo, UnidadDTO unidad) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.edificio = edificio;
        this.usuario = usuario;
        this.estadoReclamo = estadoReclamo;
        this.unidad = unidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EdificioDTO getEdificio() {
        return edificio;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
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

    public void setEdificio(EdificioDTO edificio) {
        this.edificio = edificio;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
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
                ", edificio=" + edificio +
                ", usuario=" + usuario +
                ", estadoReclamo=" + estadoReclamo +
                ", unidad=" + unidad +
                '}';
    }
}
