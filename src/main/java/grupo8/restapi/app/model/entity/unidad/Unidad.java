package grupo8.restapi.app.model.entity.unidad;

import grupo8.restapi.app.model.entity.edificio.Edificio;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
import grupo8.restapi.app.model.entity.usuarios.Inquilino;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidades")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUnidad;
    @ManyToOne
    @JoinColumn(name = "dueño_id")
    private Dueno dueño;
    private int piso;
    private String departamento;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<Inquilino> inquilinos = new ArrayList<Inquilino>();

    public Unidad(int piso, String departamento, EstadoUnidad estado) {
        this.piso = piso;
        this.departamento = departamento;
        this.estado = estado.toString();
    }

    public Unidad() {
    }

    public long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(EstadoUnidad estado) {
        this.estado = estado.toString();
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Dueno getDueño() {
        return dueño;
    }

    public void setDueño(Dueno dueño) {
        this.dueño = dueño;
    }

    public List<Inquilino> getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(List<Inquilino> inquilinos) {
        this.inquilinos = inquilinos;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "idUnidad=" + idUnidad +
                ", dueño=" + dueño +
                ", piso=" + piso +
                ", departamento='" + departamento + '\'' +
                ", estado='" + estado + '\'' +
                ", edificio=" + edificio.getIdEdificio() +
                '}';
    }
}
