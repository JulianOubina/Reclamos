package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.implementacion.DuenoDAO;
import grupo6.apitpo.service.intefaces.IDuenoService;
import grupo6.apitpo.model.entity.Dueno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public Dueno findById(Integer id) {
        return duenoDAO.getById(id);
    }

    @Override
    public void save(Dueno dueno) {
        dueno.setContraseña(new BCryptPasswordEncoder().encode(dueno.getContraseña()));

        duenoDAO.save(dueno);
    }

    @Override
    public void update(Integer id,Dueno dueno) {
        Dueno duenoExiste = duenoDAO.getById(id);

        if(duenoExiste != null){
            duenoExiste.setNombre(dueno.getNombre());
            duenoExiste.setNombreUsuario(dueno.getNombreUsuario());
            duenoExiste.setTelefono(dueno.getTelefono());
            duenoExiste.setDireccion(dueno.getDireccion());
            duenoExiste.setUnidades(dueno.getUnidades());

            duenoDAO.save(duenoExiste);
        }

    }

    @Override
    public void delete(Dueno dueno) {
        duenoDAO.delete(dueno);
    }

    @Override
    public Dueno findUser(String nombreUsuario, String contraseña) {
        return duenoDAO.findUser(nombreUsuario,contraseña);
    }

    @Override
    public boolean existe(String nombreUsuario) {
        return duenoDAO.existe(nombreUsuario);
    }
}
