package api_reclamos_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api_reclamos_spring.model.dao.IReclamoEdificioDAO;
import api_reclamos_spring.model.entity.ReclamoEdificio;

@Service
public class ReclamoEdificioImpl implements IReclamoEdificioService {
	
	@Autowired
	private IReclamoEdificioDAO reclamoEdificioDAO;
	
	@Override
	public List<ReclamoEdificio> findAll() {
		List<ReclamoEdificio> reclamos = reclamoEdificioDAO.findAll();
		return reclamos;
	}

	@Override
	public ReclamoEdificio findById(int id) {
		ReclamoEdificio reclamo = reclamoEdificioDAO.findById(id);
		return reclamo;
	}

	@Override
	public void deleteById(int id) {
		reclamoEdificioDAO.deleteById(id);

	}

}
