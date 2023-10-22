package api_reclamos_spring.service;

import java.util.List;

import api_reclamos_spring.model.entity.Unidad;

public interface IUnidadService {
	public List<Unidad> findAll();
	public Unidad findById(int id);
	public void save(Unidad unidad);
	public void update(int unidadId, Unidad unidad);
	public void deleteById(int id);
}
