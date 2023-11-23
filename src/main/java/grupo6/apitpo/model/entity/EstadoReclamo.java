package grupo6.apitpo.model.entity;

import jakarta.persistence.Embeddable;
@Embeddable
public class EstadoReclamo {
    private String estado;
    private String mensaje;

    public EstadoReclamo(String estado, String mensaje) {
        this.estado = estado.toString();
        this.mensaje = mensaje;
    }

    public EstadoReclamo() {
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
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