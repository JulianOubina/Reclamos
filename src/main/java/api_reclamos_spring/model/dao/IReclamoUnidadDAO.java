package api_reclamos_spring.model.dao;

import java.util.List;

import api_reclamos_spring.model.entity.ReclamoUnidad;

public interface IReclamoUnidadDAO {
	public List<ReclamoUnidad> findAll();
	public ReclamoUnidad findById(int id);
	public void save(ReclamoUnidad reclamo);
	public void deleteById(int id);
}
