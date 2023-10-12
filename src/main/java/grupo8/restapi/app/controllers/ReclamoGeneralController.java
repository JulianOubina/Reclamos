package grupo8.restapi.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import grupo8.restapi.app.service.intefaces.IReclamoGeneralService;
import grupo8.restapi.app.model.entity.reclamo.ReclamoGeneral;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReclamoGeneralController { // TODO NO FUNCIONA ERROR java.sql.SQLSyntaxErrorException: Unknown column 'r1_0.id_reclamo' in 'field list'
    @Autowired
    private IReclamoGeneralService reclamoGeneralService;

    @GetMapping("/reclamosGenerales")
    public List<ReclamoGeneral> getAll() {
        return reclamoGeneralService.getAll();
    }

    @GetMapping("/reclamoGeneral/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        ReclamoGeneral reclamoGeneral = reclamoGeneralService.getById(id);

        if (reclamoGeneral == null) {
            String mensaje = "El reclamoGeneral con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(reclamoGeneral, null, HttpStatus.OK);
    }

//    @GetMapping("/reclamoGeneral/reclamoGeneralParam")
//    public ResponseEntity<?> getReclamoGeneralPararm(@RequestParam("reclamoGeneralId") long reclamoGeneralId) {
//        ReclamoGeneral reclamoGeneral = reclamoGeneralService.getById(reclamoGeneralId);
//
//        if (reclamoGeneral == null) {
//            String mensaje = "El reclamoGeneral con id " + reclamoGeneralId + " no existe";
//            return new ResponseEntity<>(mensaje, null, 404);
//        }
//
//        return new ResponseEntity<>(reclamoGeneral, null, HttpStatus.OK);
//    }

    @PostMapping("/reclamoGeneral")
    public ResponseEntity<?> addReclamoGeneral(@RequestBody ReclamoGeneral reclamoGeneral) {
        reclamoGeneralService.save(reclamoGeneral);
        return new ResponseEntity<>(reclamoGeneral, null, HttpStatus.CREATED);
    }

    @PutMapping("/reclamoGeneral/{id}")
    public ResponseEntity<?> updateReclamoGeneral(@PathVariable long id, @RequestBody ReclamoGeneral reclamoGeneral){
        ReclamoGeneral reclamoGeneralViejo = reclamoGeneralService.getById(id);

        if (reclamoGeneralViejo == null) {
            String mensaje = "El reclamoGeneral con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        reclamoGeneralService.update(id, reclamoGeneral);

        return new ResponseEntity<>(reclamoGeneral, null, HttpStatus.CREATED);
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
}
