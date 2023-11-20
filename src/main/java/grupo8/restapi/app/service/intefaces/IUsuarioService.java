package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.usuarios.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> getAll();
    List<Usuario> getClients();
    Usuario getById(long id);
    void save(Usuario usuario);
    void update(long id, Usuario usuario);
    void delete(Usuario usuario);
    public Usuario findUser(String nombreUs, String contraseña);
    String darRol(Usuario usuario);
    Usuario findUser(String nombreUs);
}
