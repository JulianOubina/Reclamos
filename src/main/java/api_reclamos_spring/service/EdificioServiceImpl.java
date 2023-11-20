package api_reclamos_spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api_reclamos_spring.model.dao.IEdificioDAO;
import api_reclamos_spring.model.entity.Edificio;


@Service
@Transactional
public class EdificioServiceImpl implements IEdificioService {
	
	@Autowired
	private IEdificioDAO edificioDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Edificio> findAll() {
		List<Edificio> edificios = edificioDAO.findAll();
		return edificios;
	}

	@Override
	@Transactional(readOnly = true)
	public Edificio findById(int id) {
		Edificio edificio = edificioDAO.findById(id);
		return edificio;
	}

	@Override
	@Transactional
	public void save(Edificio edificio) {
		edificio.setId(1010);
		edificioDAO.save(edificio);
	}

	@Override
	@Transactional
	public void update(int edificioId, Edificio edificio) {
		Edificio edificioExist = edificioDAO.findById(edificioId);
		
		if(edificioExist != null) {
			edificioExist.setDueño(edificio.getDueño());
			edificioExist.setCalle(edificio.getCalle());
			edificioExist.setNumero(edificio.getNumero());
			edificioExist.setCiudad(edificio.getCiudad());
			edificioExist.setUnidades(edificio.getUnidades());
			
			edificioDAO.save(edificioExist);
		}
	}

	@Override
	public void deleteById(int id) {
		edificioDAO.deleteById(id);
	}

}
