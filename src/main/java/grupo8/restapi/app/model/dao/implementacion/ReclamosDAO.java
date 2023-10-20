package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IReclamosDAO;
import grupo8.restapi.app.model.entity.reclamo.Reclamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class ReclamosDAO implements IReclamosDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Reclamo findById(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Reclamo retorno = session.get(Reclamo.class, id);

        return retorno;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Reclamo> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Reclamo> q = session.createQuery("FROM Reclamo", Reclamo.class);
        List<Reclamo> retorno = q.getResultList();

        return retorno;
    }
}
