package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IUsuarioDAO;
import grupo8.restapi.app.model.entity.usuarios.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.Session;
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

        Query q = session.createQuery("FROM Usuario", Usuario.class);
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
        Session session = entityManager.unwrap(Session.class);

        Query q = session.createQuery("FROM Usuario WHERE nombreUs = :nombreUs", Usuario.class);
        q.setParameter("nombreUs", nombreUs);
        Usuario retorno = (Usuario) q.getSingleResult();

        if(retorno != null && checkPassword(contraseña, retorno.getContraseña())) {
            return retorno;
        }
        else {
            return null;
        }
    }

    private boolean checkPassword(String contraseña, String contraseña1) {
        return contraseña.equals(contraseña1);
    }
}
