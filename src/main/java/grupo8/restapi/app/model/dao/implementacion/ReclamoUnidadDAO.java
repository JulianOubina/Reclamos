package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IReclamoUnidadDAO;
import grupo8.restapi.app.model.entity.reclamo.ReclamoUnidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReclamoUnidadDAO implements IReclamoUnidadDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public ReclamoUnidadDAO() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReclamoUnidad> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<ReclamoUnidad> q = session.createQuery("FROM ReclamoUnidad", ReclamoUnidad.class);
        List<ReclamoUnidad> retorno = q.getResultList();
        return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public ReclamoUnidad getById(long id) {
        Session session = entityManager.unwrap(Session.class);

        ReclamoUnidad retorno = session.get(ReclamoUnidad.class, id);
        return retorno;
    }

    @Override
    @Transactional
    public void save(ReclamoUnidad reclamo) {
        Session session = entityManager.unwrap(Session.class);

        session.persist(reclamo);
    }

    @Override
    @Transactional
    public void delete(ReclamoUnidad reclamo) {
        Session session = entityManager.unwrap(Session.class);

        session.delete(reclamo);
    }
}