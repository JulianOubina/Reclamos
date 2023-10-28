package grupo8.restapi.app.controllers.unidad;

import grupo8.restapi.app.model.dto.unidad.UnidadDTO;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.service.intefaces.IDuenoService;
import grupo8.restapi.app.service.intefaces.IEdificioService;
import grupo8.restapi.app.service.intefaces.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('admin')")
@RequestMapping("api")
public class UnidadController {
    @Autowired
    private IUnidadService unidadService;
    @Autowired
    private IDuenoService duenoService;
    @Autowired
    private IEdificioService edificioService;

    @GetMapping("/unidades")
    public List<UnidadDTO> getAll() {
        List<UnidadDTO> unidadDTOList = new ArrayList<>();

        for (Unidad i : unidadService.getAll()) {
            unidadDTOList.add(parseDTO(i));
        }

        return unidadDTOList;
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Unidad unidad = unidadService.getById(id);

        if (unidad == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(unidad), null, 200);
    }

    @GetMapping("/unidadParam")
    public ResponseEntity<?> getUnidadPararm(@RequestParam("unidadId") long unidadId){
        Unidad unidad = unidadService.getById(unidadId);

        if (unidad == null){
            String mensaje = "La unidad con id " + unidadId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(unidad), null, 200);
    }

    @PostMapping("/unidad")
    public ResponseEntity<?> addUnidad(@RequestBody UnidadDTO unidadDTO) {
        Unidad unidad = parseToEntity(unidadDTO);

        if (verificarUnidadParam(unidad)){
            String mensaje = "No tiene los suficientes parametros";
            return new ResponseEntity<>(mensaje, null, 400);
        }

        unidadService.save(unidad);  // TODO SE ROMPE CON NULLS
        return new ResponseEntity<>(unidadDTO, null, 201);
    }



    @PutMapping("/unidad/{id}")
    public ResponseEntity<?> updateUnidad(@PathVariable long id, @RequestBody UnidadDTO unidadDTO){
        Unidad unidadViejo = unidadService.getById(id);

        if (unidadViejo == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Unidad unidad = parseToEntity(unidadDTO);

        if (verificarUnidadParam(unidad)){
            String mensaje = "No tiene los suficientes parametros";
            return new ResponseEntity<>(mensaje, null, 400);
        }

        unidadService.update(id, unidad);

        return new ResponseEntity<>(unidadDTO, null, 200);
    }

    @DeleteMapping("/unidad/{id}")
    public ResponseEntity<String> deleteUnidad(@PathVariable long id){
        Unidad unidad = unidadService.getById(id);

        if (unidad == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        unidadService.delete(unidad);

        String mensaje = "La unidad con id " + id + " fue eliminada";
        return new ResponseEntity<>(mensaje, null, 200);
    }

    //PARSER METHOD
    public UnidadDTO parseDTO(Unidad unidad){
        UnidadDTO unidadDTO = new UnidadDTO();
        if(unidad.getDueño() != null)
            unidadDTO.setIdDueno(unidad.getDueño().getIdUsuario());
        unidadDTO.setDepartamento(unidad.getDepartamento());
        unidadDTO.setPiso(unidad.getPiso());
        unidadDTO.setEstado(unidad.getEstado());
        if (unidad.getEdificio() != null)
            unidadDTO.setIdEdificio(unidad.getEdificio().getIdEdificio());
        return unidadDTO;
    }

    public Unidad parseToEntity(UnidadDTO unidadDTO){
        Unidad unidad = new Unidad();

        if(unidadDTO.getIdDueno() != null)
            unidad.setDueño(duenoService.findById(unidadDTO.getIdDueno()));
        unidad.setPiso(unidadDTO.getPiso());
        unidad.setDepartamento(unidadDTO.getDepartamento());
        unidad.setEstado(unidadDTO.getEstado());
        if (unidadDTO.getIdEdificio() != null)
            unidad.setEdificio(edificioService.getById(unidadDTO.getIdEdificio()));

        return unidad;
    }

    // METODOS DE VERIFICACION

    private boolean verificarUnidadParam(Unidad unidad) {
        if (unidad.getEdificio() == null)
            return true;
        if (unidad.getDueño() == null)
            return true;
        if(unidad.getEstado() == null)
            return true;
        if(unidad.getDepartamento() == null)
            return true;
        return false;
    }

}
