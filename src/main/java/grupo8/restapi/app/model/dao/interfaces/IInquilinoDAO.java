package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.usuarios.Inquilino;

import java.util.List;

public interface IInquilinoDAO {
    List<Inquilino> getAll();
    Inquilino getById(long id);
    void save(Inquilino inquilino);
    void delete(Inquilino inquilino);
    Inquilino findUser(String nombreUs, String contraseña);
    boolean existe(String nombreUs);
}

