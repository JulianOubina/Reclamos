package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.dao.implementacion.AdminDAO;
import grupo8.restapi.app.model.entity.usuarios.Admin;
import grupo8.restapi.app.service.intefaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public List<Admin> getAll() {
        return adminDAO.getAll();
    }

    @Override
    public Admin getById(long id) {
        return adminDAO.getById(id);
    }

    @Override
    public void save(Admin admin) {
        admin.setContraseña(new BCryptPasswordEncoder().encode(admin.getContraseña()));

        adminDAO.save(admin);
    }

    @Override
    public void update(long id, Admin admin) {
        Admin adminExiste = adminDAO.getById(id);

        if(adminExiste != null) {
            adminExiste.setNombre(admin.getNombre());
            adminExiste.setNombreUs(admin.getNombreUs());
            adminExiste.setTelefono(admin.getTelefono());
            adminExiste.setEmail(admin.getEmail());
            adminExiste.setDirecion(admin.getDirecion());

            adminDAO.save(adminExiste);
        }
    }

    @Override
    public void delete(Admin admin) {
        adminDAO.delete(admin);
    }

    @Override
    public Admin findUser(String nombreUs, String contraseña) {
        return adminDAO.findUser(nombreUs, contraseña);
    }
}
