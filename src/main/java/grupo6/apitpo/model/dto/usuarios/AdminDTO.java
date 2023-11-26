package grupo6.apitpo.model.dto.usuarios;

public class AdminDTO {
    private Integer idAdmin;
    private String nombre;
    private String nombreUsuario;
    private Integer telefono;
    private String direccion;

    public AdminDTO() {

    }

    public AdminDTO(Integer idAdmin,String nombre, String nombreUsuario, Integer telefono, String direccion) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
