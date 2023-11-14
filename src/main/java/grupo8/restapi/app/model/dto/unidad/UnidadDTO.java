package grupo8.restapi.app.model.dto.unidad;

public class UnidadDTO {
    private Long idUnidad;
    private Long idDueno;
    private int piso;
    private String departamento;
    private String estado;
    private Long idEdificio;

    public UnidadDTO() {
    }

    public UnidadDTO(Long idDueno, int piso, String departamento, String estado, Long edificio) {
        this.idDueno = idDueno;
        this.piso = piso;
        this.departamento = departamento;
        this.estado = estado;
        this.idEdificio = edificio;
    }

    public Long getIdDueno() {
        return idDueno;
    }

    public int getPiso() {
        return piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getEstado() {
        return estado;
    }

    public Long getIdEdificio() {
        return idEdificio;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public void setIdDueno(Long idDueno) {
        this.idDueno = idDueno;
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

    public void setIdEdificio(Long idEdificio) {
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
