package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.implementacion.AdminDAO;
import grupo6.apitpo.model.entity.Admin;
import grupo6.apitpo.service.intefaces.IAdminService;
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
    public Admin getById(Integer id) {
        return adminDAO.getById(id);
    }

    @Override
    public void save(Admin admin) {
        admin.setContraseña(new BCryptPasswordEncoder().encode(admin.getContraseña()));

        adminDAO.save(admin);
    }

    @Override
    public void update(Integer id, Admin admin) {
        Admin adminExiste = adminDAO.getById(id);

        if(adminExiste != null) {
            adminExiste.setNombre(admin.getNombre());
            adminExiste.setNombreUsuario(admin.getNombreUsuario());
            adminExiste.setTelefono(admin.getTelefono());
            adminExiste.setDireccion(admin.getDireccion());

            adminDAO.save(adminExiste);
        }
    }

    @Override
    public void delete(Admin admin) {
        adminDAO.delete(admin);
    }

    @Override
    public Admin findUser(String nombreUsuario, String contraseña) {
        return adminDAO.findUser(nombreUsuario, contraseña);
    }

    @Override
    public boolean existe(String nombreUsuario) {
        return adminDAO.existe(nombreUsuario);
    }
}
