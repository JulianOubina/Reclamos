package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.Dueno;

import java.util.List;

public interface IDuenoDAO {
    List<Dueno> getAll();
    Dueno getById(Integer id);
    void save(Dueno dueno);
    void delete(Dueno dueno);
    Dueno findUser(String nombreUsuario, String contraseña);
    boolean existe(String nombreUsuario);
}
