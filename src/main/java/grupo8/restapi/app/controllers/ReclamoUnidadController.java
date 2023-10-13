package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.entity.reclamo.ReclamoGeneral;
import grupo8.restapi.app.model.entity.reclamo.ReclamoUnidad;
import grupo8.restapi.app.service.intefaces.IReclamoUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReclamoUnidadController {
    @Autowired
    private IReclamoUnidadService reclamoUnidadService;

    @GetMapping("/reclamosUnidades")
    public List<ReclamoUnidad> getAll() {
        return reclamoUnidadService.getAll();
    }

    @GetMapping("/reclamoUnidad/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        ReclamoUnidad reclamoUnidad = reclamoUnidadService.getById(id);

        if(reclamoUnidad == null) {
            String mensaje = "El reclamoUnidad con id " + id + " no existe";
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reclamoUnidad);
    }

    @GetMapping("/reclamoUnidadParam")
    public ResponseEntity<?> getReclamoUnidadPararm(@PathVariable long reclamoUnidadId){
        ReclamoUnidad reclamoUnidad = reclamoUnidadService.getById(reclamoUnidadId);

        if(reclamoUnidad == null) {
            String mensaje = "El reclamoUnidad con id " + reclamoUnidadId + " no existe";
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reclamoUnidad);
    }

    @PostMapping("/reclamoUnidad")
    public ResponseEntity<?> addReclamoUnidad(@RequestBody ReclamoUnidad reclamoUnidad) {
        reclamoUnidadService.save(reclamoUnidad);
        return ResponseEntity.ok(reclamoUnidad);
    }

    @PutMapping("/reclamoUnidad/{id}")
    public ResponseEntity<?> updateReclamoUnidad(@PathVariable long id, @RequestBody ReclamoUnidad reclamoUnidad){
        ReclamoUnidad reclamoUnidadViejo = reclamoUnidadService.getById(id);

        if(reclamoUnidadViejo == null) {
            String mensaje = "El reclamoUnidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        reclamoUnidadService.update(id, reclamoUnidad);

        return new ResponseEntity<>(reclamoUnidad, null, HttpStatus.OK);
    }

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
}
