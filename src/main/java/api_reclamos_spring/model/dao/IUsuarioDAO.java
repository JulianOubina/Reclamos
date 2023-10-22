package api_reclamos_spring.model.dao;

import java.util.List;

import api_reclamos_spring.model.entity.Usuario;

public interface IUsuarioDAO {
	public List<Usuario> findAll();
	public Usuario findById(int id);
	public void save(Usuario usuario);
	public void deleteById(int id);
	public Usuario findUser(String username, String password);
}
