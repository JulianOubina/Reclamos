package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.dto.reclamo.EstadoReclamoDTO;
import grupo8.restapi.app.model.dto.reclamo.ReclamoGeneralDTO;
import grupo8.restapi.app.model.entity.reclamo.estado.EstadoReclamo;
import grupo8.restapi.app.service.intefaces.IEdificioService;
import grupo8.restapi.app.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import grupo8.restapi.app.service.intefaces.IReclamoGeneralService;
import grupo8.restapi.app.model.entity.reclamo.ReclamoGeneral;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReclamoGeneralController {
    @Autowired
    private IReclamoGeneralService reclamoGeneralService;
    @Autowired
    private IEdificioService edificioService;
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/reclamosGenerales")
    public List<ReclamoGeneralDTO> getAll() {       // TODO HACER DTO LAS RESPUETAS
        List<ReclamoGeneralDTO> reclamosGeneralesDTO = new ArrayList<>();

        for (ReclamoGeneral rg : reclamoGeneralService.getAll()){
            reclamosGeneralesDTO.add(parseDTO(rg));
        }

        return reclamosGeneralesDTO;
    }

    @GetMapping("/reclamoGeneral/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        ReclamoGeneral reclamoGeneral = reclamoGeneralService.getById(id);

        if (reclamoGeneral == null) {
            String mensaje = "El reclamoGeneral con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(reclamoGeneral), null, HttpStatus.OK);
    }

    @GetMapping("/reclamoGeneralParam")
    public ResponseEntity<?> getReclamoGeneralPararm(@RequestParam("reclamoGeneralId") long reclamoGeneralId) {
        ReclamoGeneral reclamoGeneral = reclamoGeneralService.getById(reclamoGeneralId);

        if (reclamoGeneral == null) {
            String mensaje = "El reclamoGeneral con id " + reclamoGeneralId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(reclamoGeneral), null, HttpStatus.OK);
    }

    @PostMapping("/reclamoGeneral")
    public ResponseEntity<?> addReclamoGeneral(@RequestBody ReclamoGeneralDTO reclamoGeneral) {
        reclamoGeneralService.save(parseEntity(reclamoGeneral));
        return new ResponseEntity<>(reclamoGeneral, null, HttpStatus.CREATED);
    }

    @PutMapping("/reclamoGeneral/{id}")
    public ResponseEntity<?> updateReclamoGeneral(@PathVariable long id, @RequestBody ReclamoGeneralDTO reclamoGeneralDTO){
        ReclamoGeneral reclamoGeneralViejo = reclamoGeneralService.getById(id);

        if (reclamoGeneralViejo == null) {
            String mensaje = "El reclamoGeneral con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        ReclamoGeneral reclamoGeneral = parseEntity(reclamoGeneralDTO);

        reclamoGeneralService.update(id, reclamoGeneral);

        return new ResponseEntity<>(reclamoGeneralDTO, null, HttpStatus.CREATED);
    }

    @DeleteMapping("/reclamoGeneral/{id}")
    public ResponseEntity<String> deleteReclamoGeneral(@PathVariable long id){
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

        reclamoGeneral.setFecha(reclamoGeneralDTO.getFecha());
        reclamoGeneral.setDescripcion(reclamoGeneralDTO.getDescripcion());

        if (reclamoGeneralDTO.getIdEdificio() != null)
            reclamoGeneral.setEdificio(edificioService.getById(reclamoGeneralDTO.getIdEdificio()));
        if (reclamoGeneralDTO.getIdUsuario() != null)
            reclamoGeneral.setUsuario(usuarioService.getById(reclamoGeneralDTO.getIdUsuario()));

        reclamoGeneral.setEstado(new EstadoReclamo(reclamoGeneralDTO.getEstado(), reclamoGeneralDTO.getMensaje()));

        reclamoGeneral.setLugar(reclamoGeneralDTO.getLugar());

        return reclamoGeneral;
    }
    private EstadoReclamoDTO parseDTO(EstadoReclamo estadoReclamo){
        EstadoReclamoDTO estadoReclamoDTO = new EstadoReclamoDTO();

        if(estadoReclamo != null) {
            estadoReclamoDTO.setEstado(estadoReclamo.getEstado());
            estadoReclamoDTO.setMensaje(estadoReclamo.getMensaje());
        }

        return estadoReclamoDTO;
    }
    private EstadoReclamo parseEntity(EstadoReclamoDTO estadoReclamoDTO) {
        EstadoReclamo estadoReclamo = new EstadoReclamo();

        estadoReclamo.setEstado(estadoReclamoDTO.estado());
        estadoReclamo.setMensaje(estadoReclamoDTO.mensaje());

        return estadoReclamo;
    }
}
