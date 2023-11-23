package grupo6.apitpo.model.dtoSinReferencias.usuarios;

public class DuenoDTO {
    private Integer idDueno;
    private String nombre;
    private String nombreUsuario;
    private Integer telefono;
    private String direcion;

    public DuenoDTO() {
    }

    public DuenoDTO(Integer idDueno,String nombre, String nombreUsuario, Integer telefono, String direcion) {
        this.idDueno = idDueno;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;

        this.direcion = direcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getDirecion() {
        return direcion;
    }

    public Integer getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(Integer idDueno) {
        this.idDueno = idDueno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }
}
