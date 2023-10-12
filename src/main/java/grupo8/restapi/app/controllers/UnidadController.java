package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.entity.unidad.Unidad;
import grupo8.restapi.app.service.intefaces.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UnidadController {
    @Autowired
    private IUnidadService unidadService;

    @GetMapping("/unidades")
    public List<Unidad> getAll() {
        return unidadService.getAll();
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Unidad unidad = unidadService.getById(id);

        if (unidad == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(unidad, null, 200);
    }

    @PostMapping("/unidad")
    public ResponseEntity<?> addUnidad(@RequestBody Unidad unidad) {
        unidadService.save(unidad);
        return new ResponseEntity<>(unidad, null, 201);
    }

    @PutMapping("/unidad/{id}")
    public ResponseEntity<?> updateUnidad(@PathVariable long id, @RequestBody Unidad unidad){
        Unidad unidadViejo = unidadService.getById(id);

        if (unidadViejo == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        unidadService.update(id, unidad);

        return new ResponseEntity<>(unidad, null, 200);
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

}
