package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.usuarios.Inquilino;

import java.util.List;

public interface IInquilinoService {
    List<Inquilino> getAll();
    Inquilino getById(long id);
    void save(Inquilino inquilino);
    void update(long id,Inquilino inquilino);
    void delete(Inquilino inquilino);
    Inquilino findUser(String nombreUs, String contraseña);
    boolean existe(String nombreUs);
}
