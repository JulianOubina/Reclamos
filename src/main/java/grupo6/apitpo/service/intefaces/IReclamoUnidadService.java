package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.ReclamoUnidad;

import java.util.List;

public interface IReclamoUnidadService {
    List<ReclamoUnidad> getAll();
    ReclamoUnidad getById(Integer id);
    void save(ReclamoUnidad reclamo);
    void update(Integer id,ReclamoUnidad reclamo);
    void delete(ReclamoUnidad reclamo);
}
