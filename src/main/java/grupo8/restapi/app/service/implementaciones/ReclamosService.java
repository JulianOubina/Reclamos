package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;
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
}
