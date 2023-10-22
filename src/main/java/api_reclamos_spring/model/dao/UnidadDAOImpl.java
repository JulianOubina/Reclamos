package api_reclamos_spring.model.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import api_reclamos_spring.model.entity.Unidad;

@Repository
public class UnidadDAOImpl implements IUnidadDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly = true) 
	public List<Unidad> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Unidad> getQuery = currentSession.createQuery("from Unidad", Unidad.class);
		List<Unidad> unidades = getQuery.getResultList();
		
		return unidades;
	}

	@Override
	@Transactional(readOnly = true) 
	public Unidad findById(int id) { 
		Session currentSession = entityManager.unwrap(Session.class);
		
		Unidad unidad = currentSession.get(Unidad.class, id);
		
		return unidad;
	}

	@Override
	public void save(Unidad unidad) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(unidad);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Unidad> theQuery = currentSession.createQuery("delete from Unidad whre id=:idUnidad");
		theQuery.setParameter("idUnidad", id);
		theQuery.executeUpdate();
	}
}