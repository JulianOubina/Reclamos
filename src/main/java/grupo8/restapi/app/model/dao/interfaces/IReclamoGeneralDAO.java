package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.reclamo.ReclamoGeneral;

import java.util.List;

public interface IReclamoGeneralDAO {
    List<ReclamoGeneral> getAll();
    ReclamoGeneral getById(long id);
    void save(ReclamoGeneral reclamo);
    void delete(ReclamoGeneral reclamo);
}

