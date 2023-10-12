package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.dao.implementacion.UsuarioDAO;
import grupo8.restapi.app.model.entity.usuarios.Usuario;
import grupo8.restapi.app.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> getAll() {
        return usuarioDAO.getAll();
    }

    @Override
    public Usuario getById(long id) {
        return usuarioDAO.getById(id);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public void update(long id, Usuario usuario) {
        Usuario usuarioExiste = usuarioDAO.getById(id);

        if(usuarioExiste != null) {
            usuarioExiste.setNombre(usuario.getNombre());
            usuarioExiste.setNombreUs(usuario.getNombreUs());
            usuarioExiste.setContraseña(usuario.getContraseña());
            usuarioExiste.setTelefono(usuario.getTelefono());
            usuarioExiste.setEmail(usuario.getEmail());
            usuarioExiste.setDirecion(usuario.getDirecion());

            usuarioDAO.save(usuario);
        }
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public Usuario findUser(String nombreUs, String contraseña) {
        return usuarioDAO.findUser(nombreUs, contraseña);
    }
}
