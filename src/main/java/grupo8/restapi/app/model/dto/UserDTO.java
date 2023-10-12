package grupo8.restapi.app.model.dto;

public class UserDTO {
    private String nombreUs;
    private String contraseña;

    public UserDTO() {
    }

    public UserDTO(String nombreUs, String contraseña) {
        this.nombreUs = nombreUs;
        this.contraseña = contraseña;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
