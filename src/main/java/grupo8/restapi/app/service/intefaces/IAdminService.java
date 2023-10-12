package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.usuarios.Admin;

import java.util.List;

public interface IAdminService {
    List<Admin> getAll();
    Admin getById(long id);
    void save(Admin admin);
    void update(long id, Admin admin);
    void delete(Admin admin);
    public Admin findUser(String nombreUs, String contraseña);
}
