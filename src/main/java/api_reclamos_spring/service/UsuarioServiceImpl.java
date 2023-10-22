package api_reclamos_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_reclamos_spring.model.dao.IUsuarioDAO;
import api_reclamos_spring.model.entity.Usuario;

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
	public Usuario findById(int id) {
		Usuario usuario = usuarioDAO.findById(id);
		return usuario;
	}

	@Override
	public void save(Usuario usuario) {
		usuario.setTelefono(1010);
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
			usuarioExist.setTelefono(101010);
			
			usuarioDAO.save(usuarioExist);
		}
	}

	@Override
	public void deleteById(int id) {
		usuarioDAO.deleteById(id);
	}

	@Override
	public Usuario findUser(String username, String password) {
		Usuario usuario = usuarioDAO.findUser(username, password);
		return usuario;
	}
}
