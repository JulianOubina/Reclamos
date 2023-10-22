package api_reclamos_spring.model.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import api_reclamos_spring.model.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly = true) 
	public List<Usuario> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Usuario> getQuery = currentSession.createQuery("from Usuario", Usuario.class);
		List<Usuario> usuarios = getQuery.getResultList();
		
		return usuarios;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
				
		Usuario usuario = currentSession.get(Usuario.class, id);
		
		return usuario;
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(usuario);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Usuario> theQuery = currentSession.createQuery("delete from Usuario whre id=:idCliente");
		theQuery.setParameter("idCliente", id);
		theQuery.executeUpdate();
	}

	@Override
	public Usuario findUser(String username, String password) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Usuario> theQuery = currentSession.createQuery("FROM Usuario WHERE username=:username", Usuario.class);
		theQuery.setParameter("username", username);

		Usuario user = theQuery.uniqueResult();

		if(user != null && checkPassword(password, user.getContraseña())) {
			return user;
		} else {
			return null;
		}
	}
	
	private boolean checkPassword(String password, String passwordDB) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("Password: " + password);
		System.out.println("passwordDB: " + passwordDB);
		boolean isPasswordMatch = passwordEncoder.matches(password, passwordDB);
		
		return isPasswordMatch;
	}

}
