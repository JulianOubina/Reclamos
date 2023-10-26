package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IAdminDAO;
import grupo8.restapi.app.model.entity.usuarios.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
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
        try {
            Session session = entityManager.unwrap(Session.class);

            Query<Admin> q = session.createQuery("FROM Admin WHERE nombreUs=:nombreUs", Admin.class);
            q.setParameter("nombreUs", nombreUs);
            Admin retorno = q.getSingleResult();

            if (retorno != null && checkPassword(contraseña, retorno.getContraseña())) {
                return retorno;
            } else {
                return null;
            }
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public boolean existe(String nombreUs) {
        try{
            Session session = entityManager.unwrap(Session.class);

            Query<Admin> q = session.createQuery("FROM Admin WHERE nombreUs=:nombreUs", Admin.class);
            q.setParameter("nombreUs", nombreUs);
            Admin retorno = q.getSingleResult();

            return retorno != null;
        }  catch (NoResultException e){
            return false;
        }
    }

    private boolean checkPassword(String contraseña, String contraseñaBD) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isPasswordMatch = passwordEncoder.matches(contraseña, contraseñaBD);
        return isPasswordMatch;
    }

}
