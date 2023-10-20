package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.entity.reclamo.Reclamo;
import grupo8.restapi.app.service.intefaces.IReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReclamosController {
    @Autowired
    private IReclamosService reclamosService;

    @GetMapping("/reclamos")
    public List<Reclamo> getAll() {
        return reclamosService.findAll();
    }

    @GetMapping("/reclamo/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        Reclamo reclamo = reclamosService.findById(id);

        if (reclamo == null){
            String mensaje = "El reclamo con id " + id + " no fue encontrado";
            return new ResponseEntity<>(mensaje, null, 404);
        }
        return new ResponseEntity<>(reclamo, null, 200);
    }
}
