package grupo6.apitpo.model.dao.interfaces;

import grupo6.apitpo.model.entity.Inquilino;

import java.util.List;

public interface IInquilinoDAO {
    List<Inquilino> getAll();
    Inquilino getById(Integer id);
    void save(Inquilino inquilino);
    void delete(Inquilino inquilino);
    Inquilino findUser(String nombreUsuario, String contraseña);
    boolean existe(String nombreUsuario);
}

