package api_reclamos_spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api_reclamos_spring.model.dao.IReclamoUnidadDAO;
import api_reclamos_spring.model.entity.ReclamoUnidad;

@Service
public class ReclamoUnidadImpl implements IReclamoUnidadService {
	
	@Autowired
	private IReclamoUnidadDAO reclamoUnidadDAO;
	
	@Override
	public List<ReclamoUnidad> findAll() {
		List<ReclamoUnidad> reclamos = reclamoUnidadDAO.findAll();
		return reclamos;
	}

	@Override
	public ReclamoUnidad findById(int id) {
		ReclamoUnidad reclamo = reclamoUnidadDAO.findById(id);
		return reclamo;
	}

	@Override
	public void deleteById(int id) {
		reclamoUnidadDAO.deleteById(id);
	}

}