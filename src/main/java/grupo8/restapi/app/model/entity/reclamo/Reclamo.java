package grupo8.restapi.app.model.entity.reclamo;

import grupo8.restapi.app.model.entity.reclamo.estado.EstadoReclamo;
import grupo8.restapi.app.model.entity.edificio.Edificio;
import grupo8.restapi.app.model.entity.usuarios.Usuario;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_reclamo", discriminatorType = DiscriminatorType.STRING)
@Table(name = "reclamos")
public abstract class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reclamo")
    protected long idReclamo;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    protected Date fecha;
    protected String descripcion;
    protected String imagen;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_edificio")
    protected Edificio Edificio;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario")
    protected Usuario usuario;
    @Embedded
    protected EstadoReclamo estado;

    public Reclamo(String descripcion, String imagen, EstadoReclamo estado) {
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estado = estado;
    }

    public Reclamo() {
    }

    public long getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(long idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public EstadoReclamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }

    public Edificio getEdificio() {
        return Edificio;
    }

    public void setEdificio(Edificio edificio) {
        Edificio = edificio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Reclamo{" +
                "idReclamo=" + idReclamo +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", Edificio=" + Edificio +
                ", estado='" + estado + '\'' +
                '}';
    }
}

