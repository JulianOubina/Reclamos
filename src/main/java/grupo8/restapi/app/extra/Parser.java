package grupo8.restapi.app.extra;

import grupo8.restapi.app.model.dto.unidad.UnidadDTO;
import grupo8.restapi.app.model.dto.usuarios.AdminDTO;
import grupo8.restapi.app.model.dto.usuarios.DuenoDTO;
import grupo8.restapi.app.model.dto.usuarios.InquilinoDTO;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.model.entity.usuarios.*;
import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import grupo8.restapi.app.model.entity.edificio.Edificio;


public class Parser {

    //  -- DUENO --
    public static DuenoDTO parseDTO(Dueno dueno){
        return new DuenoDTO(dueno.getNombre(), dueno.getNombreUs(), dueno.getTelefono(), dueno.getEmail(), dueno.getDirecion());
    }

    public static Dueno parseEntity(DuenoDTO duenoDTO){
        Dueno retorno = new Dueno();

        retorno.setNombre(duenoDTO.getNombre());
        retorno.setNombreUs(duenoDTO.getNombreUs());
        retorno.setTelefono(duenoDTO.getTelefono());
        retorno.setEmail(duenoDTO.getEmail());
        retorno.setDirecion(duenoDTO.getDirecion());

        return retorno;
    }

    // -- INQUILINO --
    public static InquilinoDTO parseDTO(Inquilino inquilino){
        return new InquilinoDTO(inquilino.getNombre(), inquilino.getNombreUs(), inquilino.getTelefono(), inquilino.getEmail(), inquilino.getDirecion(), parseDTO(inquilino.getUnidad()));
    }

    public static Inquilino parseToEntity(InquilinoDTO inquilinoDTO){
        Inquilino inquilino = new Inquilino();

        inquilino.setNombre(inquilinoDTO.getNombre());
        inquilino.setNombreUs(inquilinoDTO.getNombreUs());
        inquilino.setTelefono(inquilinoDTO.getTelefono());
        inquilino.setEmail(inquilinoDTO.getEmail());
        inquilino.setDirecion(inquilinoDTO.getDirecion());
        inquilino.setUnidad(parseToEntity(inquilinoDTO.getIdUnidad()));

        return inquilino;
    }
    // -- ADMIN --
    public static AdminDTO parseDTO(Admin admin){
        return new AdminDTO(admin.getNombre(), admin.getNombreUs(), admin.getTelefono(), admin.getEmail(), admin.getDirecion());
    }

    public static Admin parseToEntity(AdminDTO adminDTO){
        Admin admin = new Admin();

        admin.setNombre(adminDTO.getNombre());
        admin.setNombreUs(adminDTO.getNombreUs());
        admin.setTelefono(adminDTO.getTelefono());
        admin.setEmail(adminDTO.getEmail());
        admin.setDirecion(adminDTO.getDirecion());

        return admin;
    }
    // -- UNIDAD --
    public static UnidadDTO parseDTO(Unidad unidad){
        UnidadDTO unidadDTO = new UnidadDTO();
        if(unidad.getDueño() != null)
            unidadDTO.setDueno(parseDTO(unidad.getDueño()));
        unidadDTO.setDepartamento(unidad.getDepartamento());
        unidadDTO.setPiso(unidad.getPiso());
        unidadDTO.setEstado(unidad.getEstado());
        if (unidad.getEdificio() != null)
            unidadDTO.setEdificio(parseDTO(unidad.getEdificio()));
        return unidadDTO;
    }

    public static Unidad parseToEntity(UnidadDTO unidadDTO){
        Unidad unidad = new Unidad();

        unidad.setDueño(parseEntity(unidadDTO.dueno()));
        unidad.setPiso(unidadDTO.piso());
        unidad.setDepartamento(unidadDTO.departamento());
        unidad.setEstado(unidadDTO.estado());
        unidad.setEdificio(parseToEntity(unidadDTO.edificio()));

        return unidad;
    }
    // -- EDIFICIO --
    public static EdificioDTO parseDTO(Edificio edificio){
        return new EdificioDTO(edificio.getDireccion(), edificio.getCiudad(), edificio.getCodigoPostal(), edificio.getPais());
    }

    public static Edificio parseToEntity(EdificioDTO edificioDTO){
        Edificio edificio = new Edificio();

        edificio.setDireccion(edificioDTO.getDireccion());
        edificio.setCiudad(edificioDTO.getCiudad());
        edificio.setCodigoPostal(edificioDTO.getCodigoPostal());
        edificio.setPais(edificioDTO.getPais());

        return edificio;
    }
    // -- RECLAMOS --

}
