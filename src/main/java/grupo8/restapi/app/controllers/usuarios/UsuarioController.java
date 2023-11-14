package grupo8.restapi.app.controllers.usuarios;

import grupo8.restapi.app.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@PreAuthorize("hasAuthority('admin')")
@RequestMapping("api")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/nombreUs/{nombreUs}")
    public ResponseEntity<?> getNombreUs(@PathVariable String nombreUs){
        return new ResponseEntity<>(usuarioService.findUser(nombreUs), null, 200);
    }
}
