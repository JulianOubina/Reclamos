package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.reclamo.ReclamoUnidad;

import java.util.List;

public interface IReclamoUnidadService {
    List<ReclamoUnidad> getAll();
    ReclamoUnidad getById(long id);
    void save(ReclamoUnidad reclamo);
    void update(long id,ReclamoUnidad reclamo);
    void delete(ReclamoUnidad reclamo);
}
