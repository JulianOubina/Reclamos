package api_reclamos_spring.model.dao;

import java.util.List;

import api_reclamos_spring.model.entity.ReclamoEdificio;

public interface IReclamoEdificioDAO {
	public List<ReclamoEdificio> findAll();
	public ReclamoEdificio findById(int id);
	public void save(ReclamoEdificio reclamo);
	public void deleteById(int id);
}
