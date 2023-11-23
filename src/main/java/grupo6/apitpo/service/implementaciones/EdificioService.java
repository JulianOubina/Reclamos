package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.implementacion.EdificioDAO;
import grupo6.apitpo.model.entity.Edificio;
import grupo6.apitpo.model.entity.Unidad;
import grupo6.apitpo.service.intefaces.IEdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService implements IEdificioService {
    @Autowired
    private EdificioDAO edificioDAO;


    @Override
    public List<Edificio> getAll() {
        return edificioDAO.getAll();
    }

    @Override
    public Edificio getById(Integer id) {
        return edificioDAO.getById(id);
    }

    @Override
    public void save(Edificio edificio) {
        edificioDAO.save(edificio);
    }

    @Override
    public void update(Integer id, Edificio edificio) {
        Edificio edificioExiste =  edificioDAO.getById(id);

        if(edificioExiste != null){
            edificioExiste.setDireccion(edificio.getDireccion());
            edificioExiste.setCiudad(edificio.getCiudad());
            edificioExiste.setCodigoPostal(edificio.getCodigoPostal());
            edificioExiste.setPais(edificio.getPais());
            edificioExiste.setListaUnidades(edificio.getListaUnidades());

            edificioDAO.save(edificioExiste);
        }
    }

    @Override
    public void delete(Edificio edificio) {
        edificioDAO.delete(edificio);
    }

    @Override
    public void saveWithUnidades(Edificio edificio, List<Unidad> unidades) {
        edificioDAO.saveWithUnidades(edificio, unidades);
    }
}
