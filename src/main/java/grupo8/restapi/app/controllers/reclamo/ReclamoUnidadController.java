package grupo8.restapi.app.controllers.reclamo;

import grupo8.restapi.app.model.dto.reclamo.ReclamoUnidadDTO;;
import grupo8.restapi.app.model.entity.reclamo.ReclamoUnidad;
import grupo8.restapi.app.model.entity.reclamo.estado.EstadoReclamo;
import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.model.entity.usuarios.Dueno;
import grupo8.restapi.app.model.entity.usuarios.Inquilino;
import grupo8.restapi.app.model.entity.usuarios.Usuario;
import grupo8.restapi.app.service.intefaces.IEdificioService;
import grupo8.restapi.app.service.intefaces.IReclamoUnidadService;
import grupo8.restapi.app.service.intefaces.IUnidadService;
import grupo8.restapi.app.service.intefaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReclamoUnidadController {
    @Autowired
    private IReclamoUnidadService reclamoUnidadService;
    @Autowired
    private IEdificioService edificioService;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IUnidadService unidadService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/reclamosUnidades")
    public List<ReclamoUnidadDTO> getAll() {
        List<ReclamoUnidadDTO> retorno = new ArrayList<>();

        for (ReclamoUnidad ru : reclamoUnidadService.getAll()){
            retorno.add(parseDTO(ru));
        }

        return retorno;
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/reclamoUnidad/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        ReclamoUnidad reclamoUnidad = reclamoUnidadService.getById(id);

        if(reclamoUnidad == null) {
            String mensaje = "El reclamoUnidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(reclamoUnidad), null, 200);
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/reclamoUnidadParam")
    public ResponseEntity<?> getReclamoUnidadPararm(@PathVariable long reclamoUnidadId){
        ReclamoUnidad reclamoUnidad = reclamoUnidadService.getById(reclamoUnidadId);

        if(reclamoUnidad == null) {
            String mensaje = "El reclamoUnidad con id " + reclamoUnidadId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(reclamoUnidad), null, 200);
    }
    @PreAuthorize("hasAuthority('admin') or hasAuthority('inquilino') or hasAuthority('dueno')")
    @PostMapping("/reclamoUnidad")
    public ResponseEntity<?> addReclamoUnidad(@RequestBody ReclamoUnidadDTO reclamoUnidadDTO) {
        ReclamoUnidad reclamoUnidad = parseEntity(reclamoUnidadDTO);

        //  EL USUARIO TIENE QUE ESTAR RELACIONADO AL EDIFICIO

        if (!permitidoCargar(reclamoUnidad)) {
            return new ResponseEntity<>("La unidad se encuentra alquilada, solo el inquilino puede generar reclamos", null, HttpStatus.BAD_REQUEST);
        }

        reclamoUnidadService.save(reclamoUnidad);

        return new ResponseEntity<>(parseDTO(reclamoUnidad), null, HttpStatus.CREATED); // TODO TIENE Q DEOLVER EL ID
    }

    @PreAuthorize("hasAuthority('admin') or hasAuthority('inquilino') or hasAuthority('dueno')")
    @PutMapping("/reclamoUnidad/{id}")
    public ResponseEntity<?> updateReclamoUnidad(@PathVariable long id, @RequestBody ReclamoUnidadDTO reclamoUnidadDTO){
        ReclamoUnidad reclamoUnidadViejo = reclamoUnidadService.getById(id);

        if(reclamoUnidadViejo == null) {
            String mensaje = "El reclamoUnidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        ReclamoUnidad reclamoUnidad = parseEntity(reclamoUnidadDTO);

        reclamoUnidadService.update(id, reclamoUnidad);

        return new ResponseEntity<>(parseDTO(reclamoUnidad), null, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin') or hasAuthority('inquilino') or hasAuthority('dueno')")
    @DeleteMapping("/reclamoUnidad/{id}")
    public ResponseEntity<String> deleteReclamoUnidad(@PathVariable long id){
        ReclamoUnidad reclamoUnidad = reclamoUnidadService.getById(id);

        if(reclamoUnidad == null) {
            String mensaje = "El reclamoUnidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        reclamoUnidadService.delete(reclamoUnidad);

        String mensaje = "El reclamoUnidad con id " + id + " fue eliminado";
        return new ResponseEntity<>(mensaje, null, HttpStatus.OK);
    }

    // PARSE METHODS

    private ReclamoUnidadDTO parseDTO(ReclamoUnidad reclamoUnidad){
        ReclamoUnidadDTO retorno = new ReclamoUnidadDTO();

        retorno.setFecha(reclamoUnidad.getFecha());
        retorno.setDescripcion(reclamoUnidad.getDescripcion());
        if(reclamoUnidad.getUnidad() != null)
            retorno.setIdEdificio(reclamoUnidad.getEdificio().getIdEdificio());
        if(reclamoUnidad.getUsuario() != null)
            retorno.setIdUsuario(reclamoUnidad.getUsuario().getIdUsuario());
        if(reclamoUnidad.getUnidad() != null)
            retorno.setUnidad(reclamoUnidad.getUnidad().getIdUnidad());
        if(reclamoUnidad.getEstado() != null){
            retorno.setEstado(reclamoUnidad.getEstado().getEstado());
            retorno.setMensaje(reclamoUnidad.getEstado().getMensaje());
        }

        return retorno;
    }
    private ReclamoUnidad parseEntity(ReclamoUnidadDTO dto){
        ReclamoUnidad retorno = new ReclamoUnidad();

        retorno.setFecha(dto.getFecha());
        retorno.setDescripcion(dto.getDescripcion());

        if(dto.getUnidad() != null)
            retorno.setUnidad(unidadService.getById(dto.getUnidad()));

        if(dto.getIdEdificio() != null)
            retorno.setEdificio(edificioService.getById(dto.getIdEdificio()));

        if(dto.getIdUsuario() != null)
            retorno.setUsuario(usuarioService.getById(dto.getIdUsuario()));

        retorno.setEstado(new EstadoReclamo(dto.getEstado(), dto.getMensaje()));

        return retorno;
    }

    private boolean permitidoCargar(ReclamoUnidad reclamoUnidad) {
        // el dueño podrá generarlo, a menos que la unidad se encuentre alquilada en cuyo caso solo lo podrá hacer el inquilino
        boolean flag = true;

        Unidad unidad = reclamoUnidad.getUnidad();
        Usuario usuario = reclamoUnidad.getUsuario();
        String estado = unidad.getEstado().toLowerCase();

        if(usuario instanceof Dueno)
        {
            if( estado.equals("alquilado") )
                flag = false;

        }

        return flag;
    }
}
