package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.ReclamoUnidad;

import java.util.List;

public interface IReclamoUnidadDAO {
    List<ReclamoUnidad> getAll();
    ReclamoUnidad getById(Integer id);
    void save(ReclamoUnidad reclamo);
    void delete(ReclamoUnidad reclamo);
}
