package grupo6.apitpo.controllers.usuarios;

import grupo6.apitpo.model.dto.usuarios.AdminDTO;
import grupo6.apitpo.model.entity.Usuario;
import grupo6.apitpo.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/nombreUs/{nombreUsuario}")
    public ResponseEntity<?> getNombreUsuario(@PathVariable String nombreUsuario){
        return new ResponseEntity<>(parseDTO(usuarioService.findUser(nombreUsuario)), null, 200);
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
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Usuario usuario = usuarioService.getById(id);

        if(usuario == null){
            String mensaje = "El usuario con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(usuario), null, 200);
    }

    private AdminDTO parseDTO(Usuario usuario){
        return new AdminDTO(usuario.getIdUsuario(), usuario.getNombre(), usuario.getNombreUsuario(), usuario.getTelefono(), usuario.getDireccion());
    }

}