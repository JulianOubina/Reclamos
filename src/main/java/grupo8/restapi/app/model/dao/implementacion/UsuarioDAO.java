package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IUsuarioDAO;
import grupo8.restapi.app.model.entity.usuarios.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsuarioDAO implements IUsuarioDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Usuario> q = session.createQuery("FROM Usuario", Usuario.class);
        List<Usuario> retorno = q.getResultList();
        return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getById(long id) {
        Session session = entityManager.unwrap(Session.class);

        Usuario retorno = session.get(Usuario.class, id);
        return retorno;
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        Session session = entityManager.unwrap(Session.class);

        session.persist(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        Session session = entityManager.unwrap(Session.class);

        session.delete(usuario);
    }

    @Override
    @Transactional
    public Usuario findUser(String nombreUs, String contraseña) {
        try {
            Session session = entityManager.unwrap(Session.class);

            Query<Usuario> q = session.createQuery("FROM Usuario WHERE nombreUs=:nombreUs", Usuario.class);
            q.setParameter("nombreUs", nombreUs);

            Usuario retorno = (Usuario) q.getSingleResult();

            if (retorno != null && checkPassword(contraseña, retorno.getContraseña())) {
                return retorno;
            } else {
                return null;
            }
        }catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public long findUser(String nombreUs) {
        try {
            Session session = entityManager.unwrap(Session.class);

            Query<Usuario> q = session.createQuery("FROM Usuario WHERE nombreUs=:nombreUs", Usuario.class);
            q.setParameter("nombreUs", nombreUs);

            Usuario retorno = (Usuario) q.getSingleResult();

            return retorno.getIdUsuario();
        }catch (NoResultException e) {
            System.out.println("No se encontro el usuario");
            return 0;
        }

    }

    private boolean checkPassword(String contraseña, String contraseñaBD) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isPasswordMatch = passwordEncoder.matches(contraseña, contraseñaBD);
        return isPasswordMatch;
    }
}
