package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.Admin;

import java.util.List;

public interface IAdminDAO {
    List<Admin> getAll();
    Admin getById(Integer id);
    void save(Admin admin);
    void delete(Admin admin);
    Admin findUser(String nombreUsuario, String contraseña);
    boolean existe(String nombreUsuario);
}
