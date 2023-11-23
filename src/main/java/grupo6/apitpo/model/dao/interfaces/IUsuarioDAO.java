package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    List<Usuario> getAll();
    Usuario getById(Integer id);
    void save(Usuario usuario);
    void delete(Usuario usuario);
    Usuario findUser(String nombreUsuario, String contraseña);
    Usuario findUser(String nombreUsuario);
}
