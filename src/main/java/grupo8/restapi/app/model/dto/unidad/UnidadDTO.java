package grupo8.restapi.app.model.dto.unidad;

import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import grupo8.restapi.app.model.dto.usuarios.DuenoDTO;


public class UnidadDTO {
    private DuenoDTO dueno;
    private int piso;
    private String departamento;
    private String estado;
    private Long idEdificio;

    public UnidadDTO() {
    }

    public UnidadDTO(DuenoDTO dueno, int piso, String departamento, String estado, Long edificio) {
        this.dueno = dueno;
        this.piso = piso;
        this.departamento = departamento;
        this.estado = estado;
        this.idEdificio = edificio;
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

    public Long edificio() {
        return idEdificio;
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

    public void setEdificio(Long edificio) {
        this.idEdificio = edificio;
    }

    @Override
    public String toString() {
        return "UnidadDTO{" +
                "dueno=" + dueno +
                ", piso=" + piso +
                ", departamento='" + departamento + '\'' +
                ", estado='" + estado + '\'' +
                ", edificio=" + idEdificio +
                '}';
    }
}
