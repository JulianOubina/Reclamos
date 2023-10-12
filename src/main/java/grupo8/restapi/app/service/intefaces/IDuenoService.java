package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.usuarios.Dueno;

import java.util.List;

public interface IDuenoService {
    List<Dueno> findAll();
    Dueno findById(long id);
    void save(Dueno dueno);
    void update(long id,Dueno dueno);
    void delete(Dueno dueno);
    Dueno findUser(String nombreUs, String contraseña);
}
