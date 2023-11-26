package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.implementacion.InquilinoDAO;
import grupo6.apitpo.model.entity.Inquilino;
import grupo6.apitpo.service.intefaces.IInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquilinoService implements IInquilinoService {
    @Autowired
    private InquilinoDAO inquilinoDAO;


    @Override
    public List<Inquilino> getAll() {
        return inquilinoDAO.getAll();
    }

    @Override
    public Inquilino getById(Integer id) {
        return inquilinoDAO.getById(id);
    }

    @Override
    public void save(Inquilino inquilino) {
        inquilino.setContraseña(new BCryptPasswordEncoder().encode(inquilino.getContraseña()));

        inquilinoDAO.save(inquilino);
    }

    @Override
    public void update(Integer id, Inquilino inquilino) {
        Inquilino inquilinoExiste = inquilinoDAO.getById(id);

        if(inquilinoExiste != null){
            inquilinoExiste.setNombre(inquilino.getNombre());
            inquilinoExiste.setNombreUsuario(inquilino.getNombreUsuario());
            inquilinoExiste.setTelefono(inquilino.getTelefono());
            inquilinoExiste.setDireccion(inquilino.getDireccion());
            inquilinoExiste.setUnidad(inquilino.getUnidad());

            inquilinoDAO.save(inquilinoExiste);
        }
    }

    @Override
    public void delete(Inquilino inquilino) {
        inquilinoDAO.delete(inquilino);
    }

    @Override
    public Inquilino findUser(String nombreUsuario, String contraseña) {
        return inquilinoDAO.findUser(nombreUsuario,contraseña);
    }

    @Override
    public boolean existe(String nombreUsuario) {
        return inquilinoDAO.existe(nombreUsuario);
    }
}
