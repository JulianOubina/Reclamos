package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.entity.usuarios.Admin;
import grupo8.restapi.app.service.intefaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/admins")
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Admin admin = adminService.getById(id);

        if(admin == null) {
            String mensaje = "El admin con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(admin, null, HttpStatus.OK);
    }

//    @GetMapping("/admin/adminParam")
//    public ResponseEntity<?> getAdminPararm(@RequestParam("adminId") long adminId){
//        Admin admin = adminService.getById(adminId);
//
//        if(admin == null) {
//            String mensaje = "El admin con id " + adminId + " no existe";
//            return new ResponseEntity<>(mensaje, null, 404);
//        }
//
//        return new ResponseEntity<>(admin, null, HttpStatus.OK);
//    }

    @PostMapping("/admin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        adminService.save(admin);
        return new ResponseEntity<>(admin, null, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable long id, @RequestBody Admin admin){
        Admin adminViejo = adminService.getById(id);

        if(adminViejo == null) {
            String mensaje = "El admin con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        adminService.update(id, admin);

        return new ResponseEntity<>(admin, null, HttpStatus.OK);
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

}
