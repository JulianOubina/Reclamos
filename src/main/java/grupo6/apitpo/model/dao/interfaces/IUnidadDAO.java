package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.Edificio;
import grupo6.apitpo.model.entity.Unidad;
import grupo6.apitpo.model.entity.Dueno;

import java.util.List;

public interface IUnidadDAO {
    List<Unidad> getAll();
    Unidad getById(Integer id);
    void save(Unidad unidad);
    void delete(Unidad unidad);
    void conectarUnidadAEd(Unidad unidad, Edificio edificio);
    void unirDuenoUnidad(Unidad unidad, Dueno dueno);
    List<Unidad> getByEstado(String estado);
}
