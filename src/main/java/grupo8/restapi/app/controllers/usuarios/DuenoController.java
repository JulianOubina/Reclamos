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
@RequestMapping("api")
public class DuenoController {
    @Autowired
    private IDuenoService duenoService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/duenos")
    public List<DuenoDTO> getAll() {
        List<DuenoDTO> dtoList = new ArrayList<>();

        for (Dueno i : duenoService.findAll()) {
            dtoList.add(parseDTO(i));
        }

        return dtoList;
    }

    @PreAuthorize("hasAuthority('admin')")
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

    @PreAuthorize("hasAuthority('admin')")
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

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/dueno")
    public ResponseEntity<?> addDueno(@RequestBody Dueno dueno) {
        duenoService.save(dueno);
        return new ResponseEntity<>(parseDTO(dueno), null, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping("/dueno/{id}")
    public ResponseEntity<?> updateDueno(@PathVariable long id, @RequestBody DuenoDTO dto){
        Dueno duenoViejo = duenoService.findById(id);

        if(duenoViejo == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Dueno dueno = parseEntity(dto);

        duenoService.update(id, dueno);

        return new ResponseEntity<>(dto, null, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin')")
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
}
