package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.implementacion.ReclamoGeneralDAO;
import grupo6.apitpo.service.intefaces.IReclamoGeneralService;
import grupo6.apitpo.model.entity.ReclamoGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoGeneralService implements IReclamoGeneralService {
    @Autowired
    private ReclamoGeneralDAO reclamoGeneralDAO;

    @Override
    public List<ReclamoGeneral> getAll() {
        return reclamoGeneralDAO.getAll();
    }

    @Override
    public ReclamoGeneral getById(Integer id) {
        return reclamoGeneralDAO.getById(id);
    }

    @Override
    public void save(ReclamoGeneral reclamo) {
        reclamoGeneralDAO.save(reclamo);
    }

    @Override
    public void update(Integer id, ReclamoGeneral reclamo) {
        ReclamoGeneral reclamoExiste = reclamoGeneralDAO.getById(id);

        if(reclamoExiste != null){
            reclamoExiste.setDescripcion(reclamo.getDescripcion());
            reclamoExiste.setEstado(reclamo.getEstado());
            //reclamoExiste.setFecha(reclamo.getFecha());
            reclamoExiste.setEdificio(reclamo.getEdificio());
            reclamoExiste.setLugar(reclamo.getLugar());
            reclamoExiste.setImagen(reclamo.getImagen());
            reclamoExiste.setUsuario(reclamo.getUsuario());

            reclamoGeneralDAO.save(reclamoExiste);
        }
    }

    @Override
    public void delete(ReclamoGeneral reclamo) {
        reclamoGeneralDAO.delete(reclamo);
    }
}
