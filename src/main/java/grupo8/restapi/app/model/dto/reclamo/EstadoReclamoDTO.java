package grupo8.restapi.app.model.dto.reclamo;

public class EstadoReclamoDTO {
    private String estado;
    private String mensaje;

    public EstadoReclamoDTO() {
    }

    public EstadoReclamoDTO(String estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public String estado() {
        return estado;
    }

    public String mensaje() {
        return mensaje;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "EstadoReclamoDTO{" +
                "estado='" + estado + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}

