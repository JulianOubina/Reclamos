package grupo8.restapi.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import grupo8.restapi.app.service.intefaces.IEdificioService;
import grupo8.restapi.app.model.entity.edificio.Edificio;

import java.util.List;

@RestController
@RequestMapping("api")
public class EdificioController {
    @Autowired
    private IEdificioService edificioService;

    @GetMapping("/edificios")
    public List<Edificio> getAll() {
        return edificioService.getAll();
    }

    @GetMapping("/edificio/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Edificio edificio = edificioService.getById(id);

        if(edificio == null) {
            String mensaje = "El edificio con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(edificio, null, HttpStatus.OK);
    }

    @GetMapping("/edificioParam")
    public ResponseEntity<?> getAdminParam(@RequestParam("edificioId") long edificioId){
        Edificio edificio = edificioService.getById(edificioId);

        if(edificio == null) {
            String mensaje = "El edificio con id " + edificioId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(edificio, null, HttpStatus.OK);
    }

    @PostMapping("/edificio")
    public ResponseEntity<?> addEdificio(@RequestBody Edificio edificio) {
        edificioService.save(edificio);
        return new ResponseEntity<>(edificio, null, HttpStatus.CREATED);
    }

    @PutMapping("/edificio/{id}")
    public ResponseEntity<?> updateEdificio(@PathVariable long id, @RequestBody Edificio edificio){
        Edificio edificioViejo = edificioService.getById(id);

        if(edificioViejo == null) {
            String mensaje = "El edificio con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        edificioService.update(id, edificio);

        return new ResponseEntity<>(edificio, null, HttpStatus.OK);
    }

    @DeleteMapping("/edificio/{id}")
    public ResponseEntity<String> deleteEdificio(@PathVariable long id){
        Edificio edificio = edificioService.getById(id);

        if(edificio == null) {
            String mensaje = "El edificio con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        edificioService.delete(edificio);

        return new ResponseEntity<>("Edificio eliminado", null, HttpStatus.OK);
    }
}
