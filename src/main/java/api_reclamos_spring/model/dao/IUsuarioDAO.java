package api_reclamos_spring.model.dao;

import java.util.List;

import api_reclamos_spring.model.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

public interface IUsuarioDAO {
	public List<Usuario> findAll();
	public Usuario findById(int id);
	public void save(Usuario usuario);
	public void deleteById(int id);
	public Usuario findUser(String username, String password);
	public Usuario findByUsername(String username);
	public List<Usuario> findByTipo(Usuario.Tipo tipo);
}
