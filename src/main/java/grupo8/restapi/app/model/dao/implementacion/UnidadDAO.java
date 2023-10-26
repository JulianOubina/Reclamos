package grupo8.restapi.app.model.dao.implementacion;

import grupo8.restapi.app.model.dao.interfaces.IUnidadDAO;
import grupo8.restapi.app.model.entity.edificio.Edificio;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UnidadDAO implements IUnidadDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public UnidadDAO() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Unidad> getAll(){
        Session session = entityManager.unwrap(Session.class);

        Query<Unidad> q = session.createQuery("FROM Unidad", Unidad.class);
        List<Unidad> retorno = q.getResultList();
        return retorno;
    }


    @Override
    @Transactional(readOnly = true)
    public Unidad getById(long id){
        Session session = entityManager.unwrap(Session.class);

        Unidad retorno = session.get(Unidad.class, id);
        return retorno;
    }

    @Override
    @Transactional
    public void save(Unidad unidad) {
        Session session = entityManager.unwrap(Session.class);

        session.persist(unidad);
    }

    @Override
    @Transactional
    public void delete(Unidad unidad){
        Session session = entityManager.unwrap(Session.class);

        session.delete(unidad);

        Dueno dueno = unidad.getDueño();
        if( dueno != null){
            List<Unidad> unidades = dueno.getUnidades();
            unidades.remove(unidad);
            dueno.setUnidades(unidades);
            session.update(dueno);
        }
        Edificio edificio = unidad.getEdificio();
        if( edificio != null){
            List<Unidad> unidades = edificio.getListaUnidades();
            unidades.remove(unidad);
            edificio.setListaUnidades(unidades);
            session.update(edificio);
        }

    }

    @Override
    @Transactional
    public void conectarUnidadAEd(Unidad unidad, Edificio edificio){
        unidad.setEdificio(edificio);
        save(unidad);
    }

    @Override
    @Transactional
    public void unirDuenoUnidad(Unidad unidad, Dueno dueno){
        Session session = entityManager.unwrap(Session.class);

        List<Unidad> unidades = dueno.getUnidades();

        unidades.add(unidad);

        dueno.setUnidades(unidades);

        unidad.setDueño(dueno);

        session.update(unidad);
        session.update(dueno);
    }
}