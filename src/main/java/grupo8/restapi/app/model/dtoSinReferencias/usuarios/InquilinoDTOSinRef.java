package grupo8.restapi.app.model.dtoSinReferencias.usuarios;

public class InquilinoDTOSinRef {
    private Long idInquilino;
    private String nombre;
    private String nombreUs;
    private int telefono;
    private String email;
    private String direcion;
    private String unidad;

    public InquilinoDTOSinRef() {
    }

    public InquilinoDTOSinRef(String nombre, String nombreUs, int telefono, String email, String direcion, String unidad) {
        this.nombre = nombre;
        this.nombreUs = nombreUs;
        this.telefono = telefono;
        this.email = email;
        this.direcion = direcion;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDirecion() {
        return direcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public Long getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(Long idInquilino) {
        this.idInquilino = idInquilino;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
