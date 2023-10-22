package api_reclamos_spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api_reclamos_spring.model.entity.ReclamoEdificio;
import api_reclamos_spring.service.IReclamoEdificioService;



@RestController
@RequestMapping("/api")
public class ReclamoEdificioController {
	
	@Autowired
	private IReclamoEdificioService reclamoEdificioService;
	
	@GetMapping({ "/reclamosEdificio", ""})
	public List<ReclamoEdificio> findAll(){
		return reclamoEdificioService.findAll();
	}
	
	@GetMapping("/reclamosEdificio/{reclamoId}")
	public ResponseEntity<?> getReclamo(@PathVariable int reclamoId) {
		ReclamoEdificio reclamo = reclamoEdificioService.findById(reclamoId);

		if (reclamo == null) {
			String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(reclamo, HttpStatus.OK);
	}
	
	@DeleteMapping("reclamosEdificio/{reclamoId}")
	public ResponseEntity<String> deleteReclamo(@PathVariable int reclamoId) {

		ReclamoEdificio reclamo = reclamoEdificioService.findById(reclamoId);

		if (reclamo == null) {
			String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		reclamoEdificioService.deleteById(reclamoId);

		String mensaje = "Reclamo eliminado [usuarioId = " + reclamoId + "]";
		return new ResponseEntity<String>(mensaje, HttpStatus.NO_CONTENT);
	}
}
