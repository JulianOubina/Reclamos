package api_reclamos_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_reclamos_spring.model.dao.IEdificioDAO;
import api_reclamos_spring.model.entity.Edificio;


@Service
public class EdificioServiceImpl implements IEdificioService {
	
	@Autowired
	private IEdificioDAO edificioDAO;
	
	@Override
	public List<Edificio> findAll() {
		List<Edificio> edificios = edificioDAO.findAll();
		return edificios;
	}

	@Override
	public Edificio findById(int id) {
		Edificio edificio = edificioDAO.findById(id);
		return edificio;
	}

	@Override
	public void save(Edificio edificio) {
		edificio.setId(1010);
		edificioDAO.save(edificio);
	}

	@Override
	public void update(int edificioId, Edificio edificio) {
		Edificio edificioExist = edificioDAO.findById(edificioId);
		
		if(edificioExist != null) {
			edificioExist.setDueño(edificio.getDueño());
			edificioExist.setCalle(edificio.getCalle());
			edificioExist.setNumero(1010);
			edificioExist.setReclamos(edificio.getReclamos());
			
			
			edificioDAO.save(edificioExist);
		}
	}

	@Override
	public void deleteById(int id) {
		edificioDAO.deleteById(id);
	}

}
