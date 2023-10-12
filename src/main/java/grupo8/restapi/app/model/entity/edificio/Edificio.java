package grupo8.restapi.app.model.entity.edificio;

import grupo8.restapi.app.model.entity.unidad.Unidad;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "edificios")
public class Edificio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idEdificio;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String pais;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Unidad> listaUnidades = new ArrayList<Unidad>();

    public Edificio(String direccion, String ciudad, String codigoPostal, String pais) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public Edificio() {
    }

    public void setIdEdificio(long idEdificio) {
        this.idEdificio = idEdificio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setListaUnidades(List<Unidad> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    public long getIdEdificio() {
        return idEdificio;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public List<Unidad> getListaUnidades() {
        return listaUnidades;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "idEdificio=" + idEdificio +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", pais='" + pais + '\'' +
                //        ", listaUnidades=" + listaUnidades + -> PROBLEMA DE RECURSIVIDAD CON TO STRING
                '}';
    }
}

