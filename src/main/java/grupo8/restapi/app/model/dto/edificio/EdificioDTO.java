package grupo8.restapi.app.model.dto.edificio;

import grupo8.restapi.app.model.dto.unidad.UnidadDTO;
import grupo8.restapi.app.model.entity.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class EdificioDTO {
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String pais;

    public EdificioDTO() {
    }

    public EdificioDTO(String direccion, String ciudad, String codigoPostal, String pais) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
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

    @Override
    public String toString() {
        return "EdificioDTO{" +
                "direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
