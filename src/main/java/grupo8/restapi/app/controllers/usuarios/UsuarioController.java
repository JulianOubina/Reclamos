package grupo8.restapi.app.controllers.usuarios;

import grupo8.restapi.app.model.dto.usuarios.AdminDTO;
import grupo8.restapi.app.model.dto.usuarios.UsuarioDTO;
import grupo8.restapi.app.model.entity.usuarios.Admin;
import grupo8.restapi.app.model.entity.usuarios.Usuario;
import grupo8.restapi.app.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
@RequestMapping("api")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/nombreUs/{nombreUs}")
    public ResponseEntity<?> getNombreUs(@PathVariable String nombreUs){
        return new ResponseEntity<>(parseDTO(usuarioService.findUser(nombreUs)), null, 200);
    }

    @GetMapping("usuarios")
    public ResponseEntity<?> getAll(){
        List<Usuario> usuarios = usuarioService.getClients();
        List<AdminDTO> dtos = new ArrayList<>();

        for (Usuario u : usuarios) {
            dtos.add(parseDTO(u));
        }

        return new ResponseEntity<>(dtos, null, 200);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        Usuario usuario = usuarioService.getById(id);

        if(usuario == null){
            String mensaje = "El usuario con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(usuario), null, 200);
    }


    // PARSE DTO

    private AdminDTO parseDTO(Usuario usuario){
        return new AdminDTO(usuario.getIdUsuario(),usuario.getNombre(), usuario.getNombreUs(), usuario.getTelefono(), usuario.getEmail(), usuario.getDirecion());
    }

}