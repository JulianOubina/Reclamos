package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;

import java.util.List;

public interface IReclamosDAO {
    Reclamo findById(Long id);
    List<Reclamo> findAll();
}
