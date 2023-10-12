package grupo8.restapi.app.model.entity.reclamo.estado;

import jakarta.persistence.Embeddable;
@Embeddable
public class EstadoReclamo {
    private String estado;
    private String mensaje;

    public EstadoReclamo(Estados estado, String mensaje) {
        this.estado = estado.toString();
        this.mensaje = mensaje;
    }

    public EstadoReclamo() {
    }

    public String getEstado() {
        return estado;
    }
    public void setEstadoR(Estados estado) {
        this.estado = estado.toString();
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String toString(){
        return "EstadoReclamo{" +
                "estado='" + estado + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}