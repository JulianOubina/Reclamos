package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.reclamo.ReclamoUnidad;

import java.util.List;

public interface IReclamoUnidadDAO {
    List<ReclamoUnidad> getAll();
    ReclamoUnidad getById(long id);
    void save(ReclamoUnidad reclamo);
    void delete(ReclamoUnidad reclamo);
}
