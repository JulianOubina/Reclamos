package api_reclamos_spring.service;

import java.util.List;

import api_reclamos_spring.model.entity.Edificio;

public interface IEdificioService {
	public List<Edificio> findAll();
	public Edificio findById(int id);
	public void save(Edificio edificio);
	public void update(int edificioId, Edificio edificio);
	public void deleteById(int id);
}
