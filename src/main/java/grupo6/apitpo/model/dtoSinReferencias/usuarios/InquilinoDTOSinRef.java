package grupo6.apitpo.model.dtoSinReferencias.usuarios;

public class InquilinoDTOSinRef {
    private Integer idInquilino;
    private String nombre;
    private String nombreUsuario;
    private Integer telefono;
    private String direcion;
    private String unidad;

    public InquilinoDTOSinRef() {
    }

    public InquilinoDTOSinRef(String nombre, String nombreUsuario, Integer telefono, String direcion, String unidad) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.direcion = direcion;
        this.unidad = unidad;
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

    public String getUnidad() {
        return unidad;
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

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
