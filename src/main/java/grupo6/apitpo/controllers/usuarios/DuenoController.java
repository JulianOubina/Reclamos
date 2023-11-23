package grupo6.apitpo.controllers.usuarios;

import grupo6.apitpo.model.dto.usuarios.DuenoDTO;
import grupo6.apitpo.model.entity.Dueno;
import grupo6.apitpo.service.intefaces.IDuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, origins = "http://localhost:5173", allowedHeaders = "*")
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
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Dueno dueno = duenoService.findById(id);

        if(dueno == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        DuenoDTO duenoDTO = parseDTO(dueno);

        return new ResponseEntity<>(duenoDTO, null, HttpStatus.OK);
    }

    @GetMapping("/dueno/duenoParam")
    public ResponseEntity<?> getDuenoPararm(@RequestParam("duenoId") Integer duenoId){
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
        if(duenoService.findUser(dueno.getNombreUsuario(), dueno.getContraseña()) != null){
            String mensaje = "El dueno ya existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        duenoService.save(dueno);

        return new ResponseEntity<>(parseDTO(dueno), null, HttpStatus.CREATED);
    }



    @PutMapping("/dueno/{id}")
    public ResponseEntity<?> updateDueno(@PathVariable Integer id, @RequestBody DuenoDTO dto){
        Dueno duenoViejo = duenoService.findById(id);

        if(duenoViejo == null) {
            String mensaje = "El dueno con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        if(duenoService.existe(dto.getNombreUsuario()) && !dto.getNombreUsuario().equals(duenoViejo.getNombreUsuario())){
            String mensaje = "El nombre de usuario ya esta en uso";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Dueno dueno = parseEntity(dto);

        duenoService.update(id, dueno);

        return new ResponseEntity<>(dto, null, HttpStatus.OK);
    }

    @DeleteMapping("/dueno/{id}")
    public ResponseEntity<String> deleteDueno(@PathVariable Integer id){
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
        return new DuenoDTO(dueno.getIdUsuario(),dueno.getNombre(), dueno.getNombreUsuario(), dueno.getTelefono(), dueno.getDirecion());
    }

    private Dueno parseEntity(DuenoDTO duenoDTO){
        Dueno retorno = new Dueno();

        if(duenoDTO.getIdDueno() != null)
            retorno.setIdUsuario(duenoDTO.getIdDueno());
        retorno.setNombre(duenoDTO.getNombre());
        retorno.setNombreUsuario(duenoDTO.getNombreUsuario());
        retorno.setTelefono(duenoDTO.getTelefono());

        retorno.setDirecion(duenoDTO.getDirecion());

        return retorno;
    }

    // METODOS DE VERIFICACION

    private boolean controlDuenoParam(Dueno dueno) {
        if(dueno.getNombreUsuario() == null)
            return true;

        if(dueno.getContraseña() == null)
            return true;

        if(dueno.getNombre() == null)
            return true;

        return false;
    }
}
