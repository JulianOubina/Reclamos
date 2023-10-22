package api_reclamos_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api_reclamos_spring.model.dao.IUnidadDAO;
import api_reclamos_spring.model.entity.Unidad;

@Service 
public class UnidadServiceImpl implements IUnidadService {
	
	@Autowired
	private IUnidadDAO unidadDAO;
	
	@Override
	public List<Unidad> findAll() {
		List<Unidad> unidades = unidadDAO.findAll();
		return unidades;
	}

	@Override
	public Unidad findById(int id) {
		Unidad unidad = unidadDAO.findById(id);
		return unidad;
	}

	@Override
	public void save(Unidad unidad) {
		unidad.setId(1010);
		unidadDAO.save(unidad);
	}

	@Override
	public void update(int unidadId, Unidad unidad) {
		Unidad unidadExist = unidadDAO.findById(unidadId);
		
		if(unidadExist != null) {
			unidadExist.setDueño(unidad.getDueño());
			unidadExist.setEdificio(unidad.getEdificio());
			unidadExist.setInquilinos(unidad.getInquilinos());
			unidadExist.setReclamos(unidad.getReclamos());
			unidadExist.setId(1010);
			
			unidadDAO.save(unidadExist);
		}
	}

	@Override
	public void deleteById(int id) {
		unidadDAO.deleteById(id);
	}

}
