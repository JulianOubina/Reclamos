package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.ReclamoGeneral;

import java.util.List;

public interface IReclamoGeneralService {
    List<ReclamoGeneral> getAll();
    ReclamoGeneral getById(Integer id);
    void save(ReclamoGeneral reclamo);
    void update(Integer id,ReclamoGeneral reclamo);
    void delete(ReclamoGeneral reclamo);
}
