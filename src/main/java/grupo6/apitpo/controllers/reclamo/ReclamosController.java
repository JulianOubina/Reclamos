package grupo6.apitpo.controllers.reclamo;

import grupo6.apitpo.model.dto.reclamo.ReclamosDTO;
import grupo6.apitpo.model.dtoSinReferencias.reclamo.ReclamosDTOSinRef;
import grupo6.apitpo.model.entity.Reclamo;
import grupo6.apitpo.model.entity.ReclamoGeneral;
import grupo6.apitpo.model.entity.ReclamoUnidad;
import grupo6.apitpo.service.intefaces.IReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ReclamosController {
    @Autowired
    private IReclamosService reclamosService;

    // ESTE PUEDE SER EL ACCESO AL CLIENTE  //
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/reclamos")
    public List<ReclamosDTO> getAll() {
        List<ReclamosDTO> reclamosDTOS = new ArrayList<>();

        for(Reclamo i : reclamosService.findAll()){
            reclamosDTOS.add(parseDTO(i));
        }

        return reclamosDTOS;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/reclamos2")
    public List<ReclamosDTOSinRef> getAllSinRef() {
        List<ReclamosDTOSinRef> reclamosDTOS = new ArrayList<>();

        for(Reclamo i : reclamosService.findAll()){
            reclamosDTOS.add(parseDTOSinRef(i));
        }

        return reclamosDTOS;
    }



    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/estadoreclamos/{estado}")
    public List<ReclamosDTOSinRef> getByEstado(@PathVariable String estado) {
        List<ReclamosDTOSinRef> reclamosDTOS = new ArrayList<>();

        for(Reclamo i : reclamosService.findByEstado(estado)){
            reclamosDTOS.add(parseDTOSinRef(i));
        }

        return reclamosDTOS;
    }

    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    @GetMapping("/reclamo/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Reclamo reclamo = reclamosService.findById(id);

        if (reclamo == null){
            String mensaje = "El reclamo con id " + id + " no fue encontrado";
            return new ResponseEntity<>(mensaje, null, 404);
        }
        return new ResponseEntity<>(parseDTO(reclamo), null, 200);
    }

    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    @GetMapping("/reclamoSinRef/{id}")
    public ResponseEntity<?> getByIdSinRef(@PathVariable Integer id){
        Reclamo reclamo = reclamosService.findById(id);

        if (reclamo == null){
            String mensaje = "El reclamo con id " + id + " no fue encontrado";
            return new ResponseEntity<>(mensaje, null, 404);
        }
        return new ResponseEntity<>(parseDTOSinRef(reclamo), null, 200);
    }

    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    @GetMapping("/reclamo/")
    public ResponseEntity<?> getByIdEdificio(@RequestParam Integer idEdificio){
        List<Reclamo> reclamos = reclamosService.findByIdEdificio(idEdificio);

        if (reclamos == null){
            String mensaje = "El reclamo con id " + idEdificio + " no fue encontrado";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        List<ReclamosDTOSinRef> reclamosDTOS = new ArrayList<>();

        for(Reclamo i : reclamos){
            reclamosDTOS.add(parseDTOSinRef(i));
        }

        return new ResponseEntity<>(reclamosDTOS, null, 200);
    }

    // PARSER METHODS
    private ReclamosDTO parseDTO(Reclamo i) {
        ReclamosDTO reclamosDTO = new ReclamosDTO();

        reclamosDTO.setIdReclamo(i.getIdReclamo());
        reclamosDTO.setFecha(i.getFecha());
        reclamosDTO.setDescripcion(i.getDescripcion());
        try {
            reclamosDTO.setIdEdificio(i.getEdificio().getIdEdificio());
        }catch (NullPointerException e){
            reclamosDTO.setIdEdificio(null);
        }
        try {
            reclamosDTO.setIdUsuario(i.getUsuario().getIdUsuario());
        }catch (NullPointerException e){
            reclamosDTO.setIdUsuario(null);
        }
        reclamosDTO.setTipo(getTipo(i));
        reclamosDTO.setLugar(getLugar(i));
        reclamosDTO.setEstado(i.getEstado().getEstado());
        reclamosDTO.setMensaje(i.getEstado().getMensaje());

        return reclamosDTO;
    }

    private ReclamosDTOSinRef parseDTOSinRef(Reclamo i) {
        ReclamosDTOSinRef reclamosDTOSinRef = new ReclamosDTOSinRef();

        reclamosDTOSinRef.setIdReclamo(i.getIdReclamo());
        reclamosDTOSinRef.setFecha(i.getFecha());
        reclamosDTOSinRef.setDescripcion(i.getDescripcion());
        try {
            reclamosDTOSinRef.setIdEdificio(i.getEdificio().getDireccion());
        }catch (NullPointerException e){
            reclamosDTOSinRef.setIdEdificio(null);
        }
        try {
            reclamosDTOSinRef.setUsuario(i.getUsuario().getNombreUsuario());
        }catch (NullPointerException e){
            reclamosDTOSinRef.setUsuario(null);
        }
        reclamosDTOSinRef.setTipo(getTipo(i));
        reclamosDTOSinRef.setLugar(getLugar(i));
        reclamosDTOSinRef.setEstado(i.getEstado().getEstado());
        reclamosDTOSinRef.setMensaje(i.getEstado().getMensaje());

        return reclamosDTOSinRef;
    }

    private String getTipo(Reclamo i) {
        if(i instanceof ReclamoGeneral)
            return "General";
        else if (i instanceof ReclamoUnidad)
            return "Unidad";
        else
            return null;
    }

    private String getLugar(Reclamo i){
        if(i instanceof ReclamoGeneral)
            return ((ReclamoGeneral) i).getLugar();
        else if (i instanceof ReclamoUnidad){
            return "Departamento : "+((ReclamoUnidad) i).getUnidad().getDepartamento() + " Piso: " + ((ReclamoUnidad) i).getUnidad().getPiso();
        }
        else
            return null;
    }
}
