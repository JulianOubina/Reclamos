package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.reclamo.ReclamoGeneral;

import java.util.List;

public interface IReclamoGeneralService {
    List<ReclamoGeneral> getAll();
    ReclamoGeneral getById(long id);
    void save(ReclamoGeneral reclamo);
    void update(long id,ReclamoGeneral reclamo);
    void delete(ReclamoGeneral reclamo);
}
