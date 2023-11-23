package grupo6.apitpo.model.dtoSinReferencias.usuarios;

public class UsuarioDTO {
    private String nombreUsuario;
    private String contraseña;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
