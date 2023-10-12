package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.entity.usuarios.Inquilino;
import grupo8.restapi.app.service.intefaces.IInquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo8.restapi.app.model.dao.implementacion.InquilinoDAO;

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
    public Inquilino getById(long id) {
        return inquilinoDAO.getById(id);
    }

    @Override
    public void save(Inquilino inquilino) {
        inquilinoDAO.save(inquilino);
    }

    @Override
    public void update(long id, Inquilino inquilino) {
        Inquilino inquilinoExiste = inquilinoDAO.getById(id);

        if(inquilinoExiste != null){
            inquilinoExiste.setNombre(inquilino.getNombre());
            inquilinoExiste.setNombreUs(inquilino.getNombreUs());
            inquilinoExiste.setContraseña(inquilino.getContraseña());
            inquilinoExiste.setTelefono(inquilino.getTelefono());
            inquilinoExiste.setEmail(inquilino.getEmail());
            inquilinoExiste.setDirecion(inquilino.getDirecion());
            inquilinoExiste.setUnidad(inquilino.getUnidad());

            inquilinoDAO.save(inquilinoExiste);
        }
    }

    @Override
    public void delete(Inquilino inquilino) {
        inquilinoDAO.delete(inquilino);
    }

    @Override
    public Inquilino findUser(String nombreUs, String contraseña) {
        return inquilinoDAO.findUser(nombreUs,contraseña);
    }
}
