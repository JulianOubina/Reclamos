package api_reclamos_spring.model.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import api_reclamos_spring.model.entity.Edificio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EdificioDAOImpl implements IEdificioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Edificio> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Edificio> getQuery = currentSession.createQuery("from Edificio", Edificio.class);
		List<Edificio> edificios = getQuery.getResultList();
		
		return edificios;
	}

	@Override
	public Edificio findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Edificio edificio = currentSession.get(Edificio.class, id);
		
		return edificio;
	}

	@Override
	public void save(Edificio edificio) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(edificio);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Edificio> theQuery = currentSession.createQuery("delete from Edificio whre id=:idEdificio");
		theQuery.setParameter("idEdificio", id);
		theQuery.executeUpdate();
	}
}
