package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.Inquilino;

import java.util.List;

public interface IInquilinoService {
    List<Inquilino> getAll();
    Inquilino getById(Integer id);
    void save(Inquilino inquilino);
    void update(Integer id,Inquilino inquilino);
    void delete(Inquilino inquilino);
    Inquilino findUser(String nombreUsuario, String contraseña);
    boolean existe(String nombreUsuario);
}
