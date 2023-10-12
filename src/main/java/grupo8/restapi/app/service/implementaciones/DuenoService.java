package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.dao.implementacion.DuenoDAO;
import grupo8.restapi.app.model.entity.usuarios.Dueno;

import grupo8.restapi.app.service.intefaces.IDuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoService implements IDuenoService {
    @Autowired
    private DuenoDAO duenoDAO;
    @Override
    public List<Dueno> findAll() {
        List<Dueno> duenos = duenoDAO.getAll();
        return duenos;
    }

    @Override
    public Dueno findById(long id) {
        return duenoDAO.getById(id);
    }

    @Override
    public void save(Dueno dueno) {
        duenoDAO.save(dueno);
    }

    @Override
    public void update(long id,Dueno dueno) {
        Dueno duenoExiste = duenoDAO.getById(id);

        if(duenoExiste != null){
            duenoExiste.setNombre(dueno.getNombre());
            duenoExiste.setNombreUs(dueno.getNombreUs());
            duenoExiste.setContraseña(dueno.getContraseña());
            duenoExiste.setTelefono(dueno.getTelefono());
            duenoExiste.setEmail(dueno.getEmail());
            duenoExiste.setDirecion(dueno.getDirecion());
            duenoExiste.setUnidades(dueno.getUnidades());

            duenoDAO.save(duenoExiste);
        }

    }

    @Override
    public void delete(Dueno dueno) {
        duenoDAO.delete(dueno);
    }

    @Override
    public Dueno findUser(String nombreUs, String contraseña) {
        return duenoDAO.findUser(nombreUs,contraseña);
    }
}
