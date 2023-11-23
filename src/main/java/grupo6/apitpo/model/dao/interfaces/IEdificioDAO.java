package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.Edificio;
import grupo6.apitpo.model.entity.Unidad;

import java.util.List;

public interface IEdificioDAO {
    List<Edificio> getAll();
    Edificio getById(Integer id);
    void save(Edificio edificio );
    void delete(Edificio edificio);
    void saveWithUnidades(Edificio edificio, List<Unidad> unidades);


}

