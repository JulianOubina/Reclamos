package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.dto.DuenoDTO;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
import grupo8.restapi.app.service.intefaces.IDuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class DuenoController {
    @Autowired
    private IDuenoService duenoService;

    @GetMapping("/duenos")
    public List<Dueno> getAll() {
        return duenoService.findAll();
    }

    @GetMapping("/dueno/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Dueno dueno = duenoService.findById(id);

        if(dueno == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(dueno, null, HttpStatus.OK);
    }

    @GetMapping("/dueno/duenoParam")
    public ResponseEntity<?> getDuenoPararm(@RequestParam("duenoId") long duenoId){
        Dueno dueno = duenoService.findById(duenoId);

        if(dueno == null) {
            String mensaje = "El dueno con id " + duenoId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(dueno, null, HttpStatus.OK);
    }

    @PostMapping("/dueno")
    public ResponseEntity<?> addDueno(@RequestBody Dueno dueno) {
        duenoService.save(dueno);
        return new ResponseEntity<>(dueno, null, HttpStatus.CREATED);
    }

    @PutMapping("/dueno/{id}")
    public ResponseEntity<?> updateDueno(@PathVariable long id, @RequestBody Dueno dueno){
        Dueno duenoViejo = duenoService.findById(id);

        if(duenoViejo == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        duenoService.update(id, dueno);

        return new ResponseEntity<>(dueno, null, HttpStatus.OK);
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

    private DuenoDTO parseDTOs(Dueno dueno){
        return new DuenoDTO(dueno.getNombre(), dueno.getNombreUs(), dueno.getTelefono(), dueno.getEmail(), dueno.getDirecion(), dueno.getUnidades());
    }

    private Dueno parseEntity(DuenoDTO duenoDTO){
        Dueno retorno = new Dueno();

        retorno.setNombre(duenoDTO.getNombre());
        retorno.setNombreUs(duenoDTO.getNombreUs());
        retorno.setTelefono(duenoDTO.getTelefono());
        retorno.setEmail(duenoDTO.getEmail());
        retorno.setDirecion(duenoDTO.getDirecion());
        retorno.setUnidades(duenoDTO.getUnidades());

        return retorno;
    }
}
