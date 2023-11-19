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
	public Usuario findByUsername(String username) {
		Session currentSession = entityManager.unwrap(Session.class);
		try {
			Query query = currentSession.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :username");
			query.setParameter("username", username);
			return (Usuario) query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
				
		Usuario usuario = currentSession.get(Usuario.class, id);
		
		return usuario;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(Usuario usuario) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.persist(usuario);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Usuario> theQuery = currentSession.createQuery("delete from Usuario where id=:idCliente");
		theQuery.setParameter("idCliente", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findUser(String username, String password) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Usuario> theQuery = currentSession.createQuery("FROM Usuario WHERE nombreUsuario=:username", Usuario.class);
		theQuery.setParameter("username", username);

		Usuario user = theQuery.uniqueResult();

		if(user != null && checkPassword(password, user.getContraseña())) {
			return user;
		} else {
			return null;
		}
	}

	public boolean checkPassword(String plainPassword, String hashedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean prueba = passwordEncoder.matches(plainPassword, hashedPassword);
		System.out.println(prueba);
		return passwordEncoder.matches(plainPassword, hashedPassword);
	}
}
