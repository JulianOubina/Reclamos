package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.entity.reclamo.ReclamoGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo8.restapi.app.model.dao.implementacion.ReclamoGeneralDAO;
import grupo8.restapi.app.service.intefaces.IReclamoGeneralService;

import java.util.List;

@Service
public class ReclamoGeneralService implements IReclamoGeneralService{
    @Autowired
    private ReclamoGeneralDAO reclamoGeneralDAO;

    @Override
    public List<ReclamoGeneral> getAll() {
        return reclamoGeneralDAO.getAll();
    }

    @Override
    public ReclamoGeneral getById(long id) {
        return reclamoGeneralDAO.getById(id);
    }

    @Override
    public void save(ReclamoGeneral reclamo) {
        reclamoGeneralDAO.save(reclamo);
    }

    @Override
    public void update(long id, ReclamoGeneral reclamo) {
        ReclamoGeneral reclamoExiste = reclamoGeneralDAO.getById(id);

        if(reclamoExiste != null){
            reclamoExiste.setDescripcion(reclamo.getDescripcion());
            reclamoExiste.setEstado(reclamo.getEstado());
            reclamoExiste.setFecha(reclamo.getFecha());
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
