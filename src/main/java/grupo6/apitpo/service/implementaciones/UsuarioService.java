package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.implementacion.UsuarioDAO;
import grupo6.apitpo.model.entity.Admin;
import grupo6.apitpo.model.entity.Dueno;
import grupo6.apitpo.model.entity.Inquilino;
import grupo6.apitpo.model.entity.Usuario;
import grupo6.apitpo.service.intefaces.IUsuarioService;
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
    public Usuario getById(Integer id) {
        return usuarioDAO.getById(id);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public void update(Integer id, Usuario usuario) {
        Usuario usuarioExiste = usuarioDAO.getById(id);

        if(usuarioExiste != null) {
            usuarioExiste.setNombre(usuario.getNombre());
            usuarioExiste.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExiste.setTelefono(usuario.getTelefono());
            usuarioExiste.setDireccion(usuario.getDireccion());

            usuarioDAO.save(usuario);
        }
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public Usuario findUser(String nombreUsuario, String contraseña) {
        return usuarioDAO.findUser(nombreUsuario, contraseña);
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
    public Usuario findUser(String nombreUsuario) {
        return usuarioDAO.findUser(nombreUsuario);
    }
}
