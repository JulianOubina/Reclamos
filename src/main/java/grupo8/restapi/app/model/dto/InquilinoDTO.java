package grupo8.restapi.app.model.dto;

import grupo8.restapi.app.model.entity.unidad.Unidad;

public class InquilinoDTO {
    private String nombre;
    private String nombreUs;
    private int telefono;
    private String email;
    private String direcion;
    private Unidad unidad;

    public InquilinoDTO() {
    }

    public InquilinoDTO(String nombre, String nombreUs, int telefono, String email, String direcion, Unidad unidad) {
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

    public Unidad getUnidad() {
        return unidad;
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

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
