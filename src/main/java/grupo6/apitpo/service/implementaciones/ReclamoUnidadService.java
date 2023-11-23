package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.implementacion.ReclamoUnidadDAO;
import grupo6.apitpo.model.entity.ReclamoUnidad;
import grupo6.apitpo.service.intefaces.IReclamoUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ReclamoUnidad getById(Integer id) {
        return reclamoUnidadDAO.getById(id);
    }

    @Override
    public void save(ReclamoUnidad reclamo) {
        reclamoUnidadDAO.save(reclamo);
    }

    @Override
    public void update(Integer id,ReclamoUnidad reclamo) {
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
