package grupo6.apitpo.controllers.unidad;

import grupo6.apitpo.model.dto.unidad.UnidadDTO;
import grupo6.apitpo.model.dtoSinReferencias.unidad.UnidadDTOSinRef;
import grupo6.apitpo.model.entity.Unidad;
import grupo6.apitpo.service.intefaces.IDuenoService;
import grupo6.apitpo.service.intefaces.IEdificioService;
import grupo6.apitpo.service.intefaces.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("unidad")
public class UnidadController {
    @Autowired
    private IUnidadService unidadService;
    @Autowired
    private IDuenoService duenoService;
    @Autowired
    private IEdificioService edificioService;

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    public List<UnidadDTO> getAll() {
        List<UnidadDTO> unidadDTOList = new ArrayList<>();

        for (Unidad i : unidadService.getAll()) {
            unidadDTOList.add(parseDTO(i));
        }

        return unidadDTOList;
    }

    @GetMapping("/unidadesSinRef")
    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    public List<UnidadDTOSinRef> getAllSinRef() {
        List<UnidadDTOSinRef> unidadDTOList = new ArrayList<>();

        for (Unidad i : unidadService.getAll()) {
            unidadDTOList.add(parseDTOSinRef(i));
        }

        return unidadDTOList;
    }



    @GetMapping("/estado/{estado}")
    public List<UnidadDTO> getByEstado(@PathVariable String estado){
        List<UnidadDTO> unidadDTOList = new ArrayList<>();

        for (Unidad i : unidadService.getByEstado(estado)) {
            unidadDTOList.add(parseDTO(i));
        }

        return unidadDTOList;
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Unidad unidad = unidadService.getById(id);

        if (unidad == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(unidad), null, 200);
    }

    @GetMapping("/unidadParam")
    public ResponseEntity<?> getUnidadPararm(@RequestParam("unidadId") Integer unidadId){
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

        unidadService.save(unidad);
        return new ResponseEntity<>(unidadDTO, null, 201);
    }



    @PutMapping("/unidad/{id}")
    public ResponseEntity<?> updateUnidad(@PathVariable Integer id, @RequestBody UnidadDTO unidadDTO){
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
    public ResponseEntity<String> deleteUnidad(@PathVariable Integer id){
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
    //
    private UnidadDTOSinRef parseDTOSinRef(Unidad i) {
        UnidadDTOSinRef unidadDTOSinRef = new UnidadDTOSinRef();

        unidadDTOSinRef.setIdUnidad(i.getIdUnidad());
        unidadDTOSinRef.setDepartamento(i.getDepartamento());
        unidadDTOSinRef.setPiso(i.getPiso());
        unidadDTOSinRef.setEstado(i.getEstado());
        unidadDTOSinRef.setDueno(i.getDueño().getNombreUsuario());
        unidadDTOSinRef.setEdificio(i.getEdificio().getDireccion());

        return unidadDTOSinRef;
    }
    public UnidadDTO parseDTO(Unidad unidad){
        UnidadDTO unidadDTO = new UnidadDTO();
        unidadDTO.setIdUnidad(unidad.getIdUnidad());
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

        if(unidadDTO.getIdUnidad() != null)
            unidad.setIdUnidad(unidadDTO.getIdUnidad());
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
        System.out.println(unidad);

        if (unidad.getEdificio() == null){
            System.out.println(unidad.getEdificio() == null);
            return true;}
        if (unidad.getDueño() == null){
            System.out.println(unidad.getEdificio() == null);
            return true;}
        if(unidad.getEstado() == null){
            System.out.println(unidad.getEdificio() == null);
            return true;}
        if(unidad.getDepartamento() == null){
            System.out.println(unidad.getEdificio() == null);
            return true;}
        return false;
    }

}
