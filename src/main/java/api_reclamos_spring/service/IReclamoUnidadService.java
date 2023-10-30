package api_reclamos_spring.service;

import java.util.List;

import api_reclamos_spring.model.entity.ReclamoUnidad;

public interface IReclamoUnidadService {
	public List<ReclamoUnidad> findAll();
	public ReclamoUnidad findById(int id);
	public void deleteById(int id);
}