package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.entity.reclamo.ReclamoUnidad;
import grupo8.restapi.app.service.intefaces.IReclamoUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo8.restapi.app.model.dao.implementacion.ReclamoUnidadDAO;

import java.util.List;

@Service
public class ReclamoUnidadService implements IReclamoUnidadService {
    @Autowired
    private ReclamoUnidadDAO reclamoUnidadDAO;


    @Override
    public List<ReclamoUnidad> getAll() {
        return reclamoUnidadDAO.getAll();
    }

    @Override
    public ReclamoUnidad getById(long id) {
        return reclamoUnidadDAO.getById(id);
    }

    @Override
    public void save(ReclamoUnidad reclamo) {
        reclamoUnidadDAO.save(reclamo);
    }

    @Override
    public void update(long id,ReclamoUnidad reclamo) {
        ReclamoUnidad reclamoExiste = reclamoUnidadDAO.getById(id);

        if(reclamoExiste != null){

            reclamoExiste.setDescripcion(reclamo.getDescripcion());
            reclamoExiste.setEstado(reclamo.getEstado());
            //reclamoExiste.setFecha(reclamo.getFecha());
            reclamoExiste.setEdificio(reclamo.getEdificio());
            reclamoExiste.setUnidad(reclamo.getUnidad());
            reclamoExiste.setImagen(reclamo.getImagen());
            reclamoExiste.setUsuario(reclamo.getUsuario());

            reclamoUnidadDAO.save(reclamoExiste);
        }
    }

    @Override
    public void delete(ReclamoUnidad reclamo) {
        reclamoUnidadDAO.delete(reclamo);
    }
}
