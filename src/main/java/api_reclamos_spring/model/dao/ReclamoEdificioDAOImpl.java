package api_reclamos_spring.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_reclamos_spring.model.entity.ReclamoEdificio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ReclamoEdificioDAOImpl implements IReclamoEdificioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly = true)
	public List<ReclamoEdificio> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ReclamoEdificio> getQuery = currentSession.createQuery("from ReclamoEdificio", ReclamoEdificio.class);
		List<ReclamoEdificio> reclamos = getQuery.getResultList();
		
		return reclamos;
	}

	@Override
	@Transactional(readOnly = true)
	public ReclamoEdificio findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		ReclamoEdificio reclamo = currentSession.get(ReclamoEdificio.class, id);
		
		return reclamo;
	}

	@Override
	public void save(ReclamoEdificio reclamo) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(reclamo);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ReclamoEdificio> theQuery = currentSession.createQuery("delete from ReclamoEdificio whre id=:idReclamoEdificio");
		theQuery.setParameter("idReclamoEdificio", id);
		theQuery.executeUpdate();
	}

}
