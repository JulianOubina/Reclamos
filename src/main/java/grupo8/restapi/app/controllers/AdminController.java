package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.dto.usuarios.AdminDTO;
import grupo8.restapi.app.model.entity.usuarios.Admin;
import grupo8.restapi.app.service.intefaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/admins")
    public List<AdminDTO> getAll() {
        List<AdminDTO> adminDTOList = new ArrayList<>();

        for (Admin i : adminService.getAll()) {
            adminDTOList.add(parseDTO(i));
        }

        return adminDTOList;
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Admin admin = adminService.getById(id);

        if(admin == null) {
            String mensaje = "El admin con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        AdminDTO retorno = parseDTO(admin);

        return new ResponseEntity<>(retorno, null, HttpStatus.OK);
    }

    @GetMapping("/adminParam")
    public ResponseEntity<?> getAdminPararm(@RequestParam(name = "id") long adminId){
        Admin admin = adminService.getById(adminId);

        if(admin == null) {
            String mensaje = "El admin con id " + adminId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(admin), null, HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        adminService.save(admin);
        return new ResponseEntity<>(parseDTO(admin), null, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable long id, @RequestBody AdminDTO dto){
        Admin adminViejo = adminService.getById(id);

        if(adminViejo == null) {
            String mensaje = "El admin con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Admin admin = parseToEntity(dto);

        adminService.update(id, admin);

        return new ResponseEntity<>(dto, null, HttpStatus.OK);
    }

    @DeleteMapping("/admin/{adminId}")
    public ResponseEntity<String> deleteAdim(@PathVariable long adminId){
        Admin admin = adminService.getById(adminId);

        if(admin == null) {
            String mensaje = "El admin con id " + adminId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        adminService.delete(admin);

        String mensaje = "El admin con id " + adminId + " fue eliminado";
        return new ResponseEntity<>(mensaje, null, HttpStatus.OK);
    }

    // -- CONVERTIR A DTO -> ENTITY y ENTITY -> DTO -- //
    private AdminDTO parseDTO(Admin admin){
        return new AdminDTO(admin.getNombre(), admin.getNombreUs(), admin.getTelefono(), admin.getEmail(), admin.getDirecion());
    }

    private Admin parseToEntity(AdminDTO adminDTO){
        Admin admin = new Admin();

        admin.setNombre(adminDTO.getNombre());
        admin.setNombreUs(adminDTO.getNombreUs());
        admin.setTelefono(adminDTO.getTelefono());
        admin.setEmail(adminDTO.getEmail());
        admin.setDirecion(adminDTO.getDirecion());

        return admin;
    }
}
