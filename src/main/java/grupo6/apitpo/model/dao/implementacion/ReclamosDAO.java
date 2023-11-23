package grupo6.apitpo.model.dao.implementacion;

import grupo6.apitpo.model.dao.interfaces.IReclamosDAO;
import grupo6.apitpo.model.entity.Reclamo;
import grupo6.apitpo.model.entity.ImagenReclamo;
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
    public Reclamo findById(Integer id) {
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

    @Override
    public List<Reclamo> findByIdEdificio(Integer idEdificio) {
        Session session = entityManager.unwrap(Session.class);

        Query<Reclamo> q = session.createQuery("FROM Reclamo WHERE Edificio.id =: id", Reclamo.class);
        q.setParameter("id", idEdificio);

        List<Reclamo> retorno = q.getResultList();

        return retorno;
    }

    @Override
    public List<ImagenReclamo> findFotos(Reclamo reclamo) {
        Session session = entityManager.unwrap(Session.class);

        Query<ImagenReclamo> q = session.createQuery("FROM ImagenReclamo WHERE reclamo=:reclamo", ImagenReclamo.class);
        q.setParameter("reclamo", reclamo);

        List<ImagenReclamo> retorno = q.getResultList();

        return retorno;
    }

    @Override
    public List<Reclamo> findByEstado(String estado) {
        Session session = entityManager.unwrap(Session.class);

        Query<Reclamo> q = session.createQuery("FROM Reclamo WHERE estado.estado=:estado", Reclamo.class);
        q.setParameter("estado", estado);
        List<Reclamo> retorno = q.getResultList();

        return retorno;
    }
}
