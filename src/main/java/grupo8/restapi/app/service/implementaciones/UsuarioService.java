package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.dao.implementacion.UsuarioDAO;
import grupo8.restapi.app.model.entity.usuarios.Admin;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
import grupo8.restapi.app.model.entity.usuarios.Inquilino;
import grupo8.restapi.app.model.entity.usuarios.Usuario;
import grupo8.restapi.app.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private DuenoService duenoService;
    @Autowired
    private InquilinoService inquilinoService;

    @Override
    public List<Usuario> getAll() {
        return usuarioDAO.getAll();
    }

    @Override
    public List<Usuario> getClients() {
        List<Usuario> retorno = new ArrayList<>();

        List<Dueno> duenos = duenoService.findAll();
        List<Inquilino> inquilinos = inquilinoService.getAll();

        retorno.addAll(duenos);
        retorno.addAll(inquilinos);

        return retorno;
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

    public String darRol(Usuario usuario){
        if (usuario instanceof Admin){
            return "admin";
        } else if (usuario instanceof Dueno) {
            return "dueno";
        }else if (usuario instanceof Inquilino) {
            return "inquilino";
        } else {
            return null;
        }
    }

    @Override
    public Usuario findUser(String nombreUs) {
        return usuarioDAO.findUser(nombreUs);
    }
}
