package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.Admin;

import java.util.List;

public interface IAdminService {
    List<Admin> getAll();
    Admin getById(Integer id);
    void save(Admin admin);
    void update(Integer id, Admin admin);
    void delete(Admin admin);
    public Admin findUser(String nombreUsuario, String contraseña);

    boolean existe(String nombreUsuario);
}
