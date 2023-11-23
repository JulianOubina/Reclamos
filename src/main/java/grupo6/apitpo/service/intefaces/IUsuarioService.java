package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> getAll();
    List<Usuario> getClients();
    Usuario getById(Integer id);

    void save(Usuario usuario);
    void update(Integer id, Usuario usuario);
    void delete(Usuario usuario);
    public Usuario findUser(String nombreUsuario, String contraseña);
    String darRol(Usuario usuario);
    Usuario findUser(String nombreUsuario);
}
