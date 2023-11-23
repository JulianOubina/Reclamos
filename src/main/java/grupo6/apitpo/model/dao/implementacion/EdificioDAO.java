package grupo6.apitpo.model.dao.implementacion;

import grupo6.apitpo.model.dao.interfaces.IEdificioDAO;
import grupo6.apitpo.model.entity.Edificio;
import grupo6.apitpo.model.entity.Unidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EdificioDAO implements IEdificioDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public EdificioDAO() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Edificio> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Edificio> q = session.createQuery("FROM Edificio", Edificio.class);
        List<Edificio> retorno = q.getResultList();
        return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public Edificio getById(Integer id) {
        Session session = entityManager.unwrap(Session.class);

        Edificio edificio = session.get(Edificio.class, id);
        return edificio;
    }

    @Override
    @Transactional
    public void save(Edificio edificio) {
        Session session = entityManager.unwrap(Session.class);

        session.persist(edificio);
    }

    @Override
    @Transactional
    public void delete(Edificio edificio) {
        Session session = entityManager.unwrap(Session.class);

        session.delete(edificio);
    }
    @Transactional
    public void saveWithUnidades(Edificio edificio, List<Unidad> unidades) {
        /*
         * Este metodo funciona para agregar un nuevo edificio con unidades nuevas
         *
         * Tiene logica porque van de la mano
         * */
        Session session = entityManager.unwrap(Session.class);

        for (Unidad u : unidades) {
            u.setEdificio(edificio);
        }

        edificio.setListaUnidades(unidades);

        session.save(edificio);
    }
}