package grupo8.restapi.app.model.dto.usuarios;

import grupo8.restapi.app.model.dto.unidad.UnidadDTO;

public class InquilinoDTO {
    private String nombre;
    private String nombreUs;
    private int telefono;
    private String email;
    private String direcion;
    private Long idUnidad;

    public InquilinoDTO() {
    }

    public InquilinoDTO(String nombre, String nombreUs, int telefono, String email, String direcion, Long unidad) {
        this.nombre = nombre;
        this.nombreUs = nombreUs;
        this.telefono = telefono;
        this.email = email;
        this.direcion = direcion;
        this.idUnidad = unidad;
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

    public Long getIdUnidad() {
        return idUnidad;
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

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }
}
