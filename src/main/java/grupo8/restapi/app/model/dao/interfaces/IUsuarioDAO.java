package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.usuarios.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    List<Usuario> getAll();
    Usuario getById(long id);
    void save(Usuario usuario);
    void delete(Usuario usuario);
    Usuario findUser(String nombreUs, String contraseña);
    long findUser(String nombreUs);
}
