package grupo6.apitpo.model.dao.implementacion;

import grupo6.apitpo.model.dao.interfaces.IReclamoGeneralDAO;
import grupo6.apitpo.model.entity.ReclamoGeneral;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReclamoGeneralDAO implements IReclamoGeneralDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public ReclamoGeneralDAO() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReclamoGeneral> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<ReclamoGeneral> q = session.createQuery("FROM ReclamoGeneral ", ReclamoGeneral.class);
        List<ReclamoGeneral> retorno = q.getResultList();
        return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public ReclamoGeneral getById(Integer id) {
        Session session = entityManager.unwrap(Session.class);

        ReclamoGeneral retorno = session.get(ReclamoGeneral.class, id);
        return retorno;
    }

    @Override
    @Transactional
    public void save(ReclamoGeneral reclamo) {
        Session session = entityManager.unwrap(Session.class);

        session.persist(reclamo);
    }

    @Override
    @Transactional
    public void delete(ReclamoGeneral reclamo) {
        Session session = entityManager.unwrap(Session.class);

        session.delete(reclamo);
    }
}