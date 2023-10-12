package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.usuarios.Dueno;

import java.util.List;

public interface IDuenoDAO {
    List<Dueno> getAll();
    Dueno getById(long id);
    void save(Dueno dueno);
    void delete(Dueno dueno);
    Dueno findUser(String nombreUs, String contraseña);
}
