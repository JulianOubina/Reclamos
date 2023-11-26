package grupo6.apitpo.model.dao.implementacion;

import grupo6.apitpo.model.dao.interfaces.IInquilinoDAO;
import grupo6.apitpo.model.entity.Reclamo;
import grupo6.apitpo.model.entity.Unidad;
import grupo6.apitpo.model.entity.Inquilino;
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
public class InquilinoDAO implements IInquilinoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public InquilinoDAO() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inquilino> getAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Inquilino> q = session.createQuery("FROM Inquilino", Inquilino.class);
        List<Inquilino> retorno = q.getResultList();
        return retorno;
    }

    @Override
    @Transactional(readOnly = true)
    public Inquilino getById(Integer id) {
        Session session = entityManager.unwrap(Session.class);

        Inquilino retorno = session.get(Inquilino.class, id);
        return retorno;
    }

    @Override
    @Transactional
    public void save(Inquilino inquilino) {
        Session session = entityManager.unwrap(Session.class);


        if(inquilino.getUnidad() != null){
            Unidad unidad = inquilino.getUnidad();

            List<Inquilino> inquilinos = unidad.getInquilinos();

            inquilinos.add(inquilino);

            unidad.setInquilinos(inquilinos);

            session.persist(unidad);
        }

        session.persist(inquilino);

    }

    @Override
    @Transactional
    public void delete(Inquilino inquilino) {
        Session session = entityManager.unwrap(Session.class);

        Unidad unidad = inquilino.getUnidad();

        if(unidad != null) {
            List<Inquilino> inquilinos = unidad.getInquilinos();
            inquilinos.remove(inquilino);

            unidad.setInquilinos(inquilinos);

            session.update(unidad);
        }

        List<Reclamo> reclamos = inquilino.getReclamos();

        for (Reclamo r: reclamos){
            r.setUsuario(null);
            session.update(r);
        }

        session.delete(inquilino);
    }

    @Override
    public Inquilino findUser(String nombreUsuario, String contraseña) {
        try{
            Session currentSession = entityManager.unwrap(Session.class);

            Query<Inquilino> theQuery = currentSession.createQuery("FROM Inquilino WHERE nombreUsuario=:username", Inquilino.class);
            theQuery.setParameter("username", nombreUsuario);

            Inquilino inquilino = theQuery.uniqueResult();

            if(inquilino != null && checkPassword(contraseña, inquilino.getContraseña())) {
                return inquilino;
            } else {
                return null;
            }
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public boolean existe(String nombreUsuario) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);

            Query<Inquilino> theQuery = currentSession.createQuery("FROM Inquilino WHERE nombreUsuario=:username", Inquilino.class);
            theQuery.setParameter("username", nombreUsuario);

            Inquilino inquilino = theQuery.uniqueResult();

            return inquilino != null;
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
