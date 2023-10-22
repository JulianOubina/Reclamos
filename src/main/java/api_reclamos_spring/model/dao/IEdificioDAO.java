package api_reclamos_spring.model.dao;

import java.util.List;

import api_reclamos_spring.model.entity.Edificio;

public interface IEdificioDAO {
	public List<Edificio> findAll();
	public Edificio findById(int id);
	public void save(Edificio edificio);
	public void deleteById(int id);
}
