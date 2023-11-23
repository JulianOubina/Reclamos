package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.Dueno;

import java.util.List;

public interface IDuenoService {
    List<Dueno> findAll();
    Dueno findById(Integer id);
    void save(Dueno dueno);
    void update(Integer id,Dueno dueno);
    void delete(Dueno dueno);
    Dueno findUser(String nombreUsuario, String contraseña);
    boolean existe(String nombreUsuario);
}
