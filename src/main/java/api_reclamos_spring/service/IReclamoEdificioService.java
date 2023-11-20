package api_reclamos_spring.service;

import java.util.List;

import api_reclamos_spring.model.entity.ReclamoEdificio;

public interface IReclamoEdificioService {
	public List<ReclamoEdificio> findAll();
	public ReclamoEdificio findById(int id);

    void update(int id, ReclamoEdificio reclamo);

    public void deleteById(int id);
}
