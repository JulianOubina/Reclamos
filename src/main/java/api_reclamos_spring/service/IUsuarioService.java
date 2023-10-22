package api_reclamos_spring.service;

import java.util.List;

import api_reclamos_spring.model.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(int id);
	public void save(Usuario usuario);
	public void update(int usuarioId, Usuario usuario);
	public void deleteById(int id);
	public Usuario findUser(String username, String password);
}
