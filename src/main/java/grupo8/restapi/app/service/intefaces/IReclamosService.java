package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;

import java.util.List;

public interface IReclamosService {
    Reclamo findById(Long id);
    List<Reclamo> findAll();
    List<Reclamo> findByIdEdificio(long idEdificio);
}
