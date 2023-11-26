package grupo6.apitpo.controllers.usuarios;

import grupo6.apitpo.model.dto.usuarios.AdminDTO;
import grupo6.apitpo.model.entity.Admin;
import grupo6.apitpo.service.intefaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/search")
    public List<AdminDTO> getAll() {
        List<AdminDTO> adminDTOList = new ArrayList<>();

        for (Admin i : adminService.getAll()) {
            adminDTOList.add(parseDTO(i));
        }

        return adminDTOList;
    }

    @GetMapping("/searchById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);

        if(admin == null) {
            String mensaje = "El admin con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        AdminDTO retorno = parseDTO(admin);

        return new ResponseEntity<>(retorno, null, HttpStatus.OK);
    }

    @GetMapping("searchParam/adminParam")
    public ResponseEntity<?> getAdminPararm(@RequestParam(name = "id") Integer adminId){
        Admin admin = adminService.getById(adminId);

        if(admin == null) {
            String mensaje = "El admin con id " + adminId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(admin), null, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {

        if(controlAdminParam(admin)){
            String mensaje = "No tiene los parametros minimo para ingresarlo";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        if (adminService.findUser(admin.getNombreUsuario(), admin.getContraseña()) != null){
            String mensaje = "El admin ya existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        adminService.save(admin);

        return new ResponseEntity<>(parseDTO(admin), null, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable Integer id, @RequestBody AdminDTO dto){
        Admin adminViejo = adminService.getById(id);

        if(adminViejo == null) {
            String mensaje = "El admin con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        if(adminService.existe(dto.getNombreUsuario()) && !dto.getNombreUsuario().equals(adminViejo.getNombreUsuario())){
            String mensaje = "El nombre de usuario ya esta en uso";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Admin admin = parseToEntity(dto);

        adminService.update(id, admin);

        return new ResponseEntity<>(dto, null, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<String> deleteAdim(@PathVariable Integer adminId){
        Admin admin = adminService.getById(adminId);

        if(admin == null) {
            String mensaje = "El admin con id " + adminId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        adminService.delete(admin);

        String mensaje = "El admin con id " + adminId + " fue eliminado";
        return new ResponseEntity<>(mensaje, null, HttpStatus.OK);
    }

    private AdminDTO parseDTO(Admin admin){
        return new AdminDTO(admin.getIdUsuario(),admin.getNombre(), admin.getNombreUsuario(), admin.getTelefono(), admin.getDireccion());
    }

    private Admin parseToEntity(AdminDTO adminDTO){
        Admin admin = new Admin();

        if(adminDTO.getIdAdmin() != null)
            admin.setIdUsuario(adminDTO.getIdAdmin());
        admin.setNombre(adminDTO.getNombre());
        admin.setNombreUsuario(adminDTO.getNombreUsuario());
        admin.setTelefono(adminDTO.getTelefono());
        admin.setDireccion(adminDTO.getDireccion());

        return admin;
    }
    private boolean controlAdminParam(Admin admin) {
        if(admin.getNombreUsuario() == null)
            return true;

        if(admin.getContraseña() == null)
            return true;

        if(admin.getNombre() == null)
            return true;

        return false;
    }
}
