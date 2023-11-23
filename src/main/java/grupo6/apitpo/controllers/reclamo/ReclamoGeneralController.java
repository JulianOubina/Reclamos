package grupo6.apitpo.controllers.reclamo;

import grupo6.apitpo.model.dto.reclamo.ReclamoGeneralDTO;
import grupo6.apitpo.model.entity.EstadoReclamo;
import grupo6.apitpo.model.entity.Inquilino;
import grupo6.apitpo.model.entity.Usuario;
import grupo6.apitpo.service.intefaces.IEdificioService;
import grupo6.apitpo.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import grupo6.apitpo.service.intefaces.IReclamoGeneralService;
import grupo6.apitpo.model.entity.ReclamoGeneral;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class ReclamoGeneralController {
    @Autowired
    private IReclamoGeneralService reclamoGeneralService;
    @Autowired
    private IEdificioService edificioService;
    @Autowired
    private IUsuarioService usuarioService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/reclamosGenerales")
    public List<ReclamoGeneralDTO> getAll() {
        List<ReclamoGeneralDTO> reclamosGeneralesDTO = new ArrayList<>();

        for (ReclamoGeneral rg : reclamoGeneralService.getAll()){
            reclamosGeneralesDTO.add(parseDTO(rg));
        }

        return reclamosGeneralesDTO;
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/reclamoGeneral/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        ReclamoGeneral reclamoGeneral = reclamoGeneralService.getById(id);

        if (reclamoGeneral == null) {
            String mensaje = "El reclamoGeneral con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(reclamoGeneral), null, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/reclamoGeneralParam")
    public ResponseEntity<?> getReclamoGeneralPararm(@RequestParam("reclamoGeneralId") Integer reclamoGeneralId) {
        ReclamoGeneral reclamoGeneral = reclamoGeneralService.getById(reclamoGeneralId);

        if (reclamoGeneral == null) {
            String mensaje = "El reclamoGeneral con id " + reclamoGeneralId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(reclamoGeneral), null, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    @PostMapping("/reclamoGeneral")
    public ResponseEntity<?> addReclamoGeneral(@RequestBody ReclamoGeneralDTO reclamoGeneralDTO) {
        ReclamoGeneral reclamoGeneral = parseEntity(reclamoGeneralDTO);

        if(verificarReclamoParam(reclamoGeneral)){
            String mensaje = "El reclamoGeneral no tiene todos los parametros necesarios o estan erroneos";
            return new ResponseEntity<>(mensaje, null, 400);
        }

        reclamoGeneralService.save(reclamoGeneral);

        return new ResponseEntity<>(reclamoGeneral.getIdReclamo(), null, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    @PutMapping("/reclamoGeneral/{id}")
    public ResponseEntity<?> updateReclamoGeneral(@PathVariable Integer id, @RequestBody ReclamoGeneralDTO reclamoGeneralDTO){
        ReclamoGeneral reclamoGeneralViejo = reclamoGeneralService.getById(id);

        if (reclamoGeneralViejo == null) {
            String mensaje = "El reclamoGeneral con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        ReclamoGeneral reclamoGeneral = parseEntity(reclamoGeneralDTO);

        if(verificarReclamoParam(reclamoGeneral)){
            String mensaje = "El reclamoGeneral no tiene todos los parametros necesarios o estan erroneos";
            return new ResponseEntity<>(mensaje, null, 400);
        }

        reclamoGeneralService.update(id, reclamoGeneral);

        return new ResponseEntity<>(reclamoGeneralDTO, null, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    @DeleteMapping("/reclamoGeneral/{id}")
    public ResponseEntity<String> deleteReclamoGeneral(@PathVariable Integer id){
        ReclamoGeneral reclamoGeneral = reclamoGeneralService.getById(id);

        if (reclamoGeneral == null) {
            String mensaje = "El reclamoGeneral con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        reclamoGeneralService.delete(reclamoGeneral);

        String mensaje = "ReclamoGeneral con el id "+ id +" fue eliminado";
        return new ResponseEntity<>(mensaje, null, HttpStatus.OK);
    }

    // PARSE METHODS

    private ReclamoGeneralDTO parseDTO(ReclamoGeneral reclamoGeneral){
        ReclamoGeneralDTO reclamoGeneralDTO = new ReclamoGeneralDTO();

        reclamoGeneralDTO.setIdReclamo(reclamoGeneral.getIdReclamo());

        reclamoGeneralDTO.setFecha(reclamoGeneral.getFecha());

        reclamoGeneralDTO.setDescripcion(reclamoGeneral.getDescripcion());

        if (reclamoGeneral.getEdificio() != null)
            reclamoGeneralDTO.setIdEdificio(reclamoGeneral.getEdificio().getIdEdificio());

        if (reclamoGeneral.getUsuario() != null)
            reclamoGeneralDTO.setIdUsuario(reclamoGeneral.getUsuario().getIdUsuario());

        if (reclamoGeneral.getEstado() != null) {
            reclamoGeneralDTO.setEstado(reclamoGeneral.getEstado().getEstado());

            reclamoGeneralDTO.setMensaje(reclamoGeneral.getEstado().getMensaje());
        }
        reclamoGeneralDTO.setLugar(reclamoGeneral.getLugar());

        return reclamoGeneralDTO;
    }

    private ReclamoGeneral parseEntity(ReclamoGeneralDTO reclamoGeneralDTO){
        ReclamoGeneral reclamoGeneral = new ReclamoGeneral();

        if(reclamoGeneralDTO.getIdReclamo() != null)
            reclamoGeneral.setIdReclamo(reclamoGeneralDTO.getIdReclamo());

        // reclamoGeneral.setFecha(reclamoGeneralDTO.getFecha());
        reclamoGeneral.setDescripcion(reclamoGeneralDTO.getDescripcion());

        if (reclamoGeneralDTO.getIdEdificio() != null)
            reclamoGeneral.setEdificio(edificioService.getById(reclamoGeneralDTO.getIdEdificio()));
        if (reclamoGeneralDTO.getIdUsuario() != null)
            reclamoGeneral.setUsuario(usuarioService.getById(reclamoGeneralDTO.getIdUsuario()));

        reclamoGeneral.setEstado(new EstadoReclamo(reclamoGeneralDTO.getEstado(), reclamoGeneralDTO.getMensaje()));

        reclamoGeneral.setLugar(reclamoGeneralDTO.getLugar());

        return reclamoGeneral;
    }

    // METODOS DE VERIFICACION

    private boolean verificarReclamoParam(ReclamoGeneral reclamoGeneal) {
        if(reclamoGeneal.getEstado() == null)
            return true;
        else{
            if(reclamoGeneal.getEstado().getEstado() == null)
                return true;
            if(reclamoGeneal.getEstado().getMensaje() == null)
                return true;
        }

        if(reclamoGeneal.getUsuario() == null)
            return true;
        if(reclamoGeneal.getEdificio() == null)
            return true;
        if (reclamoGeneal.getLugar() == null)
            return true;

        Usuario usuario = reclamoGeneal.getUsuario(); // VALIDACION DE USUARIO //
        if (usuario instanceof Inquilino){
            if (((Inquilino) usuario).getUnidad().getEdificio().getIdEdificio() != reclamoGeneal.getEdificio().getIdEdificio())
                return true;
        }

        return false;
    }
}
