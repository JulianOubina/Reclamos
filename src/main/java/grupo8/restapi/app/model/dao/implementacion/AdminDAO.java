package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IAdminDAO;
import grupo8.restapi.app.model.entity.usuarios.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AdminDAO implements IAdminDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public AdminDAO() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Admin> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Admin> q = session.createQuery("FROM Admin", Admin.class);
        List<Admin> retorno = q.getResultList();
        return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public Admin getById(long id) {
        Session session = entityManager.unwrap(Session.class);

        Admin retorno = session.get(Admin.class, id);
        return retorno;
    }
    @Override
    @Transactional
    public void save(Admin admin) {
        Session session = entityManager.unwrap(Session.class);

        session.persist(admin);
    }

    @Override
    @Transactional
    public void delete(Admin admin) {
        Session session = entityManager.unwrap(Session.class);

        session.delete(admin);
    }

    @Override
    public Admin findUser(String nombreUs, String contraseña) {
        Session session = entityManager.unwrap(Session.class);

        Query<Admin> q = session.createQuery("FROM Admin WHERE nombreUs=:nombreUs", Admin.class);
        q.setParameter("nombreUs", nombreUs);
        Admin retorno = q.getSingleResult();

        if(retorno != null && checkPassword(contraseña, retorno.getContraseña())) {
            return retorno;
        } else {
            return null;
        }
    }

    private boolean checkPassword(String contraseña, String contraseña1) {
        return contraseña.equals(contraseña1);
    }

}
