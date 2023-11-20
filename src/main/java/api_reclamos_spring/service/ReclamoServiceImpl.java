package api_reclamos_spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api_reclamos_spring.model.dao.IReclamoDAO;
import api_reclamos_spring.model.entity.Reclamo;

@Service
public class ReclamoServiceImpl implements IReclamoService {
	
	@Autowired
	private IReclamoDAO reclamoDAO;
	
	@Override
	public List<Reclamo> findAll() {
		List<Reclamo> reclamos = reclamoDAO.findAll();
		return reclamos;
	}

	@Override
	public Reclamo findById(int id) {
		Reclamo reclamo = reclamoDAO.findById(id);
		return reclamo;
	}

	@Override
	public void deleteById(int id) {
		reclamoDAO.deleteById(id);
	}

}
