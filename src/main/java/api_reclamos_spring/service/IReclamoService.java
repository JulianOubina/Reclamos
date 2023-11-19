package api_reclamos_spring.service;

import java.util.List;

import api_reclamos_spring.model.entity.Reclamo;

public interface IReclamoService {
	public List<Reclamo> findAll();
	public Reclamo findById(int id);
	public void save(Reclamo reclamo);
	public void update(int reclamoId, Reclamo reclamo);
	public void deleteById(int id);
}
