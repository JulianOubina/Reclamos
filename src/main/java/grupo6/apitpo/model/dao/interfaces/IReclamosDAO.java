package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.Reclamo;
import grupo6.apitpo.model.entity.ImagenReclamo;

import java.util.List;

public interface IReclamosDAO {
    Reclamo findById(Integer id);
    List<Reclamo> findAll();
    List<Reclamo> findByIdEdificio(Integer idEdificio);
    List<ImagenReclamo> findFotos(Reclamo reclamo);
    List<Reclamo> findByEstado(String estado);
}
