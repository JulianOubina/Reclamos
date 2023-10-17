package grupo8.restapi.app.model.dto.unidad;

import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import grupo8.restapi.app.model.dto.usuarios.DuenoDTO;


public class UnidadDTO {
    private DuenoDTO dueno;
    private int piso;
    private String departamento;
    private String estado;
    private EdificioDTO edificio;

    public UnidadDTO() {
    }

    public UnidadDTO(DuenoDTO dueno, int piso, String departamento, String estado, EdificioDTO edificio) {
        this.dueno = dueno;
        this.piso = piso;
        this.departamento = departamento;
        this.estado = estado;
        this.edificio = edificio;
    }

    public DuenoDTO dueno() {
        return dueno;
    }

    public int piso() {
        return piso;
    }

    public String departamento() {
        return departamento;
    }

    public String estado() {
        return estado;
    }

    public EdificioDTO edificio() {
        return edificio;
    }

    public void setDueno(DuenoDTO dueno) {
        this.dueno = dueno;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEdificio(EdificioDTO edificio) {
        this.edificio = edificio;
    }
}
