package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.Reclamo;
import grupo6.apitpo.model.entity.ImagenReclamo;

import java.util.List;

public interface IReclamosService {
    Reclamo findById(Integer id);
    List<Reclamo> findAll();
    List<Reclamo> findByIdEdificio(Integer idEdificio);
    List<ImagenReclamo> findFotos(Reclamo reclamo);
    List<Reclamo> findByEstado(String estado);
}
