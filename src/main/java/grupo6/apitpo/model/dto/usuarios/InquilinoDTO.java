package grupo6.apitpo.model.dto.usuarios;

public class InquilinoDTO {
    private Integer idInquilino;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private Integer telefono;
    private String direcion;
    private Integer idUnidad;

    public InquilinoDTO() {
    }

    public InquilinoDTO(String nombre, String apellido, String nombreUsuario, Integer telefono, String direcion, Integer unidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.direcion = direcion;
        this.idUnidad = unidad;
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

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public Integer getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(Integer idInquilino) {
        this.idInquilino = idInquilino;
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

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }
}
