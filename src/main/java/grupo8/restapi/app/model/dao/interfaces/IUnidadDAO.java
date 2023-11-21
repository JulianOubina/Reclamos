package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.edificio.Edificio;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.model.entity.usuarios.Dueno;

import java.util.List;

public interface IUnidadDAO {
    List<Unidad> getAll();
    Unidad getById(long id);
    void save(Unidad unidad);
    void delete(Unidad unidad);
    void conectarUnidadAEd(Unidad unidad, Edificio edificio);
    void unirDuenoUnidad(Unidad unidad, Dueno dueno);
    List<Unidad> getByEstado(String estado);
}
