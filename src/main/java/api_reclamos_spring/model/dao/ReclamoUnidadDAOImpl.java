package api_reclamos_spring.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_reclamos_spring.model.entity.Reclamo;
import api_reclamos_spring.model.entity.ReclamoUnidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ReclamoUnidadDAOImpl implements IReclamoUnidadDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly = true)
	public List<ReclamoUnidad> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ReclamoUnidad> getQuery = currentSession.createQuery("from ReclamoUnidad", ReclamoUnidad.class);
		List<ReclamoUnidad> reclamos = getQuery.getResultList();
		
		return reclamos;
	}

	@Override
	@Transactional(readOnly = true)
	public ReclamoUnidad findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		ReclamoUnidad reclamo = currentSession.get(ReclamoUnidad.class, id);
		
		return reclamo;
	}

	@Override
	public void save(ReclamoUnidad reclamo) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(reclamo);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ReclamoUnidad> theQuery = currentSession.createQuery("delete from ReclamoUnidad whre id=:idReclamoUnidad");
		theQuery.setParameter("idReclamoUnidad", id);
		theQuery.executeUpdate();
	}

}
