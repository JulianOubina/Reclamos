package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IDuenoDAO;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
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
public class DuenoDAO implements IDuenoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public DuenoDAO() {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Dueno> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Dueno> q = session.createQuery("FROM Dueno", Dueno.class);
        List<Dueno> retorno = q.getResultList();
        return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public Dueno getById(long id) {
        Session session = entityManager.unwrap(Session.class);

        Dueno retorno = session.get(Dueno.class, id);
        return retorno;
    }

    @Override
    @Transactional
    public void save(Dueno dueno) {
        Session session = entityManager.unwrap(Session.class);

        session.persist(dueno);
    }

    @Override
    @Transactional
    public void delete(Dueno dueno) {
        Session session = entityManager.unwrap(Session.class);

        List<Unidad> unidades = dueno.getUnidades();

        for (Unidad u : unidades) {
            u.setDueño(null);
            session.update(u);
        }

        session.delete(dueno);
    }

    @Override
    public Dueno findUser(String nombreUs, String contraseña) {
        try {
            Session session = entityManager.unwrap(Session.class);

            Query<Dueno> q = session.createQuery("FROM Dueno WHERE nombreUs=:nombreUs", Dueno.class);
            q.setParameter("nombreUs", nombreUs);
            Dueno retorno = q.getSingleResult();

            if (retorno != null && checkPassword(contraseña, retorno.getContraseña())) {
                return retorno;
            } else {
                return null;
            }
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public boolean existe(String nombreUs) {
        try {
            Session session = entityManager.unwrap(Session.class);

            Query<Dueno> q = session.createQuery("FROM Dueno WHERE nombreUs=:nombreUs", Dueno.class);
            q.setParameter("nombreUs", nombreUs);
            Dueno retorno = q.getSingleResult();

            return retorno != null;
        }catch (NoResultException e){
            return false;
        }
    }

    private boolean checkPassword(String contraseña, String contraseñaBD) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isPasswordMatch = passwordEncoder.matches(contraseña, contraseñaBD);
        return isPasswordMatch;
    }
}

