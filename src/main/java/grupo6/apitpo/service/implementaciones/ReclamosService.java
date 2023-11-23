package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.interfaces.IReclamosDAO;
import grupo6.apitpo.model.entity.Reclamo;
import grupo6.apitpo.model.entity.ImagenReclamo;
import grupo6.apitpo.service.intefaces.IReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamosService implements IReclamosService {
    @Autowired
    private IReclamosDAO reclamoDAO;

    @Override
    public Reclamo findById(Integer id) {
        return reclamoDAO.findById(id);
    }

    @Override
    public List<Reclamo> findAll() {
        return reclamoDAO.findAll();
    }

    @Override
    public List<Reclamo> findByIdEdificio(Integer idEdificio) {
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
