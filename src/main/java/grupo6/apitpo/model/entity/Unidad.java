package grupo6.apitpo.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidades")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnidad;
    @ManyToOne
    @JoinColumn(name = "dueño_id")
    private Dueno dueño;
    private Integer piso;
    private String departamento;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<Inquilino> inquilinos = new ArrayList<Inquilino>();
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<ReclamoUnidad> reclamos = new ArrayList<ReclamoUnidad>();


    public Unidad(Integer piso, String departamento, EstadoUnidad estado) {
        this.piso = piso;
        this.departamento = departamento;
        this.estado = estado.toString();
    }

    public Unidad() {
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
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

    public List<ReclamoUnidad> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<ReclamoUnidad> reclamos) {
        this.reclamos = reclamos;
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
