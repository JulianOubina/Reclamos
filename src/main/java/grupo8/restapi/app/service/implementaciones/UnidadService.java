package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.dao.implementacion.UnidadDAO;
import grupo8.restapi.app.model.entity.edificio.Edificio;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
import grupo8.restapi.app.service.intefaces.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadService implements IUnidadService {
    @Autowired
    private UnidadDAO unidadDAO;


    @Override
    public List<Unidad> getAll() {
        return unidadDAO.getAll();
    }

    @Override
    public Unidad getById(long id) {
        return unidadDAO.getById(id);
    }

    @Override
    public void save(Unidad unidad) {
        unidadDAO.save(unidad);
    }

    @Override
    public void update(long id, Unidad unidad) {
        Unidad unidadExiste = unidadDAO.getById(id);

        if(unidadExiste != null){
            unidadExiste.setDueño(unidad.getDueño());
            unidadExiste.setPiso(unidad.getPiso());
            unidadExiste.setEdificio(unidad.getEdificio());
            unidadExiste.setInquilinos(unidad.getInquilinos());
            unidadExiste.setEstado(unidad.getEstado());
            unidadExiste.setDepartamento(unidad.getDepartamento());

            unidadDAO.save(unidadExiste);
        }
    }

    @Override
    public void delete(Unidad unidad) {
        unidadDAO.delete(unidad);
    }

    @Override
    public void conectarUnidadAEd(Unidad unidad, Edificio edificio) {
        unidadDAO.conectarUnidadAEd(unidad, edificio);
    }

    @Override
    public void unirDuenoUnidad(Unidad unidad, Dueno dueno) {
        unidadDAO.unirDuenoUnidad(unidad, dueno);
    }
}
