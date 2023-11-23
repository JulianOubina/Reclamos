package grupo6.apitpo.model.dto.unidad;

public class UnidadDTO {
    private Integer idUnidad;
    private Integer idDueno;
    private Integer piso;
    private String departamento;
    private String estado;
    private Integer idEdificio;

    public UnidadDTO() {
    }

    public UnidadDTO(Integer idDueno, Integer piso, String departamento, String estado, Integer edificio) {
        this.idDueno = idDueno;
        this.piso = piso;
        this.departamento = departamento;
        this.estado = estado;
        this.idEdificio = edificio;
    }

    public Integer getIdDueno() {
        return idDueno;
    }

    public Integer getPiso() {
        return piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getIdEdificio() {
        return idEdificio;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public void setIdDueno(Integer idDueno) {
        this.idDueno = idDueno;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdEdificio(Integer idEdificio) {
        this.idEdificio = idEdificio;
    }

    @Override
    public String toString() {
        return "UnidadDTO{" +
                "dueno=" + idDueno +
                ", piso=" + piso +
                ", departamento='" + departamento + '\'' +
                ", estado='" + estado + '\'' +
                ", edificio=" + idEdificio +
                '}';
    }
}
