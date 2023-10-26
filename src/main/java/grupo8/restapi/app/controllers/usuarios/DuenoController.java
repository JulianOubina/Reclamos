package grupo8.restapi.app.controllers.usuarios;

import grupo8.restapi.app.model.dto.usuarios.DuenoDTO;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
import grupo8.restapi.app.service.intefaces.IDuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('admin')")
@RequestMapping("api")
public class DuenoController {
    @Autowired
    private IDuenoService duenoService;


    @GetMapping("/duenos")
    public List<DuenoDTO> getAll() {
        List<DuenoDTO> dtoList = new ArrayList<>();

        for (Dueno i : duenoService.findAll()) {
            dtoList.add(parseDTO(i));
        }

        return dtoList;
    }

    @GetMapping("/dueno/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Dueno dueno = duenoService.findById(id);

        if(dueno == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        DuenoDTO duenoDTO = parseDTO(dueno);

        return new ResponseEntity<>(duenoDTO, null, HttpStatus.OK);
    }

    @GetMapping("/dueno/duenoParam")
    public ResponseEntity<?> getDuenoPararm(@RequestParam("duenoId") long duenoId){
        Dueno dueno = duenoService.findById(duenoId);

        if(dueno == null) {
            String mensaje = "El dueno con id " + duenoId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        DuenoDTO duenoDTO = parseDTO(dueno);

        return new ResponseEntity<>(duenoDTO, null, HttpStatus.OK);
    }

    @PostMapping("/dueno")
    public ResponseEntity<?> addDueno(@RequestBody Dueno dueno) {
        if(controlDuenoParam(dueno)){
            String mensaje = "No tiene los parametros minimo para ingresarlo";
            return new ResponseEntity<>(mensaje, null, 404);
        }
        if(duenoService.findUser(dueno.getNombreUs(), dueno.getContraseña()) != null){
            String mensaje = "El dueno ya existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        duenoService.save(dueno);

        return new ResponseEntity<>(parseDTO(dueno), null, HttpStatus.CREATED);
    }



    @PutMapping("/dueno/{id}")
    public ResponseEntity<?> updateDueno(@PathVariable long id, @RequestBody DuenoDTO dto){
        Dueno duenoViejo = duenoService.findById(id);

        if(duenoViejo == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        if(duenoService.existe(dto.getNombreUs()) && !dto.getNombreUs().equals(duenoViejo.getNombreUs())){
            String mensaje = "El nombre de usuario ya esta en uso";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Dueno dueno = parseEntity(dto);

        duenoService.update(id, dueno);

        return new ResponseEntity<>(dto, null, HttpStatus.OK);
    }

    @DeleteMapping("/dueno/{id}")
    public ResponseEntity<String> deleteDueno(@PathVariable long id){
        Dueno dueno = duenoService.findById(id);

        if(dueno == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        duenoService.delete(dueno);

        return new ResponseEntity<>("El dueno con id " + id + " fue eliminado", null, HttpStatus.OK);
    }

    // CONVERTIN ENTITY -> DTO y DTO -> ENTITY

    private DuenoDTO parseDTO(Dueno dueno){
        return new DuenoDTO(dueno.getNombre(), dueno.getNombreUs(), dueno.getTelefono(), dueno.getEmail(), dueno.getDirecion());
    }

    private Dueno parseEntity(DuenoDTO duenoDTO){
        Dueno retorno = new Dueno();

        retorno.setNombre(duenoDTO.getNombre());
        retorno.setNombreUs(duenoDTO.getNombreUs());
        retorno.setTelefono(duenoDTO.getTelefono());
        retorno.setEmail(duenoDTO.getEmail());
        retorno.setDirecion(duenoDTO.getDirecion());

        return retorno;
    }

    // METODOS DE VERIFICACION

    private boolean controlDuenoParam(Dueno dueno) {
        if(dueno.getNombreUs() == null)
            return true;

        if(dueno.getContraseña() == null)
            return true;

        if(dueno.getNombre() == null)
            return true;

        return false;
    }
}
