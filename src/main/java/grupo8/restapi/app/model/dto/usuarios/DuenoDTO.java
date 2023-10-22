package grupo8.restapi.app.model.dto.usuarios;

public class DuenoDTO {
    private String nombre;
    private String nombreUs;
    private int telefono;
    private String email;
    private String direcion;
    public DuenoDTO() {
    }

    public DuenoDTO(String nombre, String nombreUs, int telefono, String email, String direcion) {
        this.nombre = nombre;
        this.nombreUs = nombreUs;
        this.telefono = telefono;
        this.email = email;
        this.direcion = direcion;
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
}
