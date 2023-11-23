package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.ReclamoGeneral;

import java.util.List;

public interface IReclamoGeneralDAO {
    List<ReclamoGeneral> getAll();
    ReclamoGeneral getById(Integer id);
    void save(ReclamoGeneral reclamo);
    void delete(ReclamoGeneral reclamo);
}

