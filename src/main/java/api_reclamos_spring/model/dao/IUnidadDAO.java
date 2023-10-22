package api_reclamos_spring.model.dao;

import java.util.List;

import api_reclamos_spring.model.entity.Unidad;

public interface IUnidadDAO {
	public List<Unidad> findAll();
	public Unidad findById(int id);
	public void save(Unidad usuario);
	public void deleteById(int id);
}
