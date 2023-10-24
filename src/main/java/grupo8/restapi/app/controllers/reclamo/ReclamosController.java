package grupo8.restapi.app.controllers.reclamo;

import grupo8.restapi.app.model.dto.reclamo.ReclamoGeneralDTO;
import grupo8.restapi.app.model.dto.reclamo.ReclamosDTO;
import grupo8.restapi.app.model.entity.reclamo.Reclamo;
import grupo8.restapi.app.model.entity.reclamo.ReclamoGeneral;
import grupo8.restapi.app.model.entity.reclamo.ReclamoUnidad;
import grupo8.restapi.app.service.intefaces.IReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReclamosController {
    @Autowired
    private IReclamosService reclamosService;

    // ESTE PUEDE SER EL ACCESO AL CLIENTE  //
    @GetMapping("/reclamos")
    public List<ReclamosDTO> getAll() {
        List<ReclamosDTO> reclamosDTOS = new ArrayList<>();

        for(Reclamo i : reclamosService.findAll()){
            reclamosDTOS.add(parseDTO(i));
        }

        return reclamosDTOS;
    }

    @GetMapping("/reclamo/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        Reclamo reclamo = reclamosService.findById(id);

        if (reclamo == null){
            String mensaje = "El reclamo con id " + id + " no fue encontrado";
            return new ResponseEntity<>(mensaje, null, 404);
        }
        return new ResponseEntity<>(parseDTO(reclamo), null, 200);
    }

    @GetMapping("/reclamo/")
    public ResponseEntity<?> getByIdEdificio(@RequestParam long idEdificio){
        List<Reclamo> reclamos = reclamosService.findByIdEdificio(idEdificio);

        if (reclamos == null){
            String mensaje = "El reclamo con id " + idEdificio + " no fue encontrado";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        List<ReclamosDTO> reclamosDTOS = new ArrayList<>();

        for(Reclamo i : reclamos){
            reclamosDTOS.add(parseDTO(i));
        }

        return new ResponseEntity<>(reclamosDTOS, null, 200);
    }

    // PARSER METHODS
    private ReclamosDTO parseDTO(Reclamo i) {
        ReclamosDTO reclamosDTO = new ReclamosDTO();

        reclamosDTO.setFecha(i.getFecha());
        reclamosDTO.setDescripcion(i.getDescripcion());
        reclamosDTO.setIdEdificio(i.getEdificio().getIdEdificio());
        reclamosDTO.setIdUsuario(i.getUsuario().getIdUsuario());
        reclamosDTO.setLugar(getLugar(i));
        reclamosDTO.setEstado(i.getEstado().getEstado());
        reclamosDTO.setMensaje(i.getEstado().getMensaje());

        return reclamosDTO;
    }

    private String getLugar(Reclamo i){
        if(i instanceof ReclamoGeneral)
            return ((ReclamoGeneral) i).getLugar();
        else if (i instanceof ReclamoUnidad){
            return "Departamento : "+((ReclamoUnidad) i).getUnidad().getDepartamento() + " piso: " + ((ReclamoUnidad) i).getUnidad().getPiso();
        }
        else
            return null;
    }
}
