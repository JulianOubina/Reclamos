package grupo8.restapi.app.model.dtoSinReferencias.unidad;

public class UnidadDTOSinRef {
    private Long idUnidad;
    private String dueno;
    private int piso;
    private String departamento;
    private String estado;
    private String edificio;

    public UnidadDTOSinRef() {
    }

    public UnidadDTOSinRef(String idDueno, int piso, String departamento, String estado, String edificio) {
        this.dueno = idDueno;
        this.piso = piso;
        this.departamento = departamento;
        this.estado = estado;
        this.edificio = edificio;
    }

    public String getDueno() {
        return dueno;
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

    public String getEdificio() {
        return edificio;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public void setDueno(String dueno) {
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

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "UnidadDTO{" +
                "dueno=" + dueno +
                ", piso=" + piso +
                ", departamento='" + departamento + '\'' +
                ", estado='" + estado + '\'' +
                ", edificio=" + edificio +
                '}';
    }
}
