package api_reclamos_spring.model.dao;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import api_reclamos_spring.model.entity.Reclamo;

@Repository
public class ReclamoDAOImpl implements IReclamoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly = true) 
	public List<Reclamo> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Reclamo> getQuery = currentSession.createQuery("from Reclamo", Reclamo.class);
		List<Reclamo> reclamos = getQuery.getResultList();
		
		return reclamos;
	}

	@Override
	@Transactional(readOnly = true) 
	public Reclamo findById(int id) { 
		Session currentSession = entityManager.unwrap(Session.class);
		
		Reclamo reclamo = currentSession.get(Reclamo.class, id);
		
		return reclamo;
	}

	@Override
	public void save(Reclamo reclamo) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(reclamo);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Reclamo> theQuery = currentSession.createQuery("delete from Reclamo whre id=:idReclamo");
		theQuery.setParameter("idReclamo", id);
		theQuery.executeUpdate();
	}
}
