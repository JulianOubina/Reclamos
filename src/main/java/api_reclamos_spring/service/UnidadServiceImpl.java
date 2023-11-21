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
		unidadDAO.save(unidad);
	}

	@Override
	public void update(int unidadId, Unidad unidad) {
		Unidad unidadExist = unidadDAO.findById(unidadId);
		
		if(unidadExist != null) {
			unidadExist.setPiso(unidad.getPiso());
			unidadExist.setDepartamento(unidad.getDepartamento());
			unidadExist.setEdificio(unidad.getEdificio());
			unidadExist.setInquilino(unidad.getInquilino());
			unidadExist.setId(unidad.getId());
			
			unidadDAO.save(unidadExist);
		}
	}

	@Override
	public void deleteById(int id) {
		unidadDAO.deleteById(id);
	}

}
