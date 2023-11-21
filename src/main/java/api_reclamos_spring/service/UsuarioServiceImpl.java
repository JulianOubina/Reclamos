package api_reclamos_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_reclamos_spring.model.dao.IUsuarioDAO;
import api_reclamos_spring.model.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	
	@Override
	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioDAO.findAll();
		return usuarios;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		Usuario usuario = usuarioDAO.findById(id);
		return usuario;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		Usuario usuario = usuarioDAO.findByUsername(username);
		return usuario;
	}

	@Override
	@Transactional(noRollbackFor = Exception.class)
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);
	}

	@Override
	public void update(int usuarioId, Usuario usuario) {
		Usuario usuarioExist = usuarioDAO.findById(usuarioId);
		
		if(usuarioExist != null) {
			usuarioExist.setNombre_usuario(usuario.getNombre_usuario());
			usuarioExist.setContraseña(usuario.getContraseña());
			usuarioExist.setNombre(usuario.getNombre());
			usuarioExist.setApellido(usuario.getApellido());
			usuarioExist.setTelefono(usuario.getTelefono());
			usuarioExist.setTipo(usuario.getTipo());

			usuarioDAO.save(usuarioExist);
		}
	}

	@Override
	public void deleteById(int id) {
		usuarioDAO.deleteById(id);
	}

	@Override
	public List<Usuario> findByTipo(Usuario.Tipo tipo) {

		List<Usuario> usuarios = usuarioDAO.findByTipo(tipo);

		return usuarios;
	}

	@Override
	public Usuario findUser(String username, String password) {

		Usuario usuario = usuarioDAO.findUser(username, password);

		return usuario;
	}
}
