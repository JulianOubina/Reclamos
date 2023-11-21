package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;
import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;
import grupo8.restapi.app.service.intefaces.IReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo8.restapi.app.model.dao.interfaces.IReclamosDAO;

import java.util.List;

@Service
public class ReclamosService implements IReclamosService {
    @Autowired
    private IReclamosDAO reclamoDAO;

    @Override
    public Reclamo findById(Long id) {
        return reclamoDAO.findById(id);
    }

    @Override
    public List<Reclamo> findAll() {
        return reclamoDAO.findAll();
    }

    @Override
    public List<Reclamo> findByIdEdificio(long idEdificio) {
        return reclamoDAO.findByIdEdificio(idEdificio);
    }

    @Override
    public List<ImagenReclamo> findFotos(Reclamo reclamo) {
        return reclamoDAO.findFotos(reclamo);
    }

    @Override
    public List<Reclamo> findByEstado(String estado) {
        return reclamoDAO.findByEstado(estado);
    }
}
