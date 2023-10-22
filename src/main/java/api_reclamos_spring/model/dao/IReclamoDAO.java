package api_reclamos_spring.model.dao;

import java.util.List;

import api_reclamos_spring.model.entity.Reclamo;



public interface IReclamoDAO {
	public List<Reclamo> findAll();
	public Reclamo findById(int id);
	public void save(Reclamo reclamo);
	public void deleteById(int id);
}
