package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.usuarios.Admin;

import java.util.List;

public interface IAdminDAO {
    List<Admin> getAll();
    Admin getById(long id);
    void save(Admin admin);
    void delete(Admin admin);
    Admin findUser(String nombreUs, String contraseña);
}
