package api_reclamos_spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api_reclamos_spring.model.entity.Reclamo;
import api_reclamos_spring.service.IReclamoService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ReclamoController {
	
	@Autowired
	private IReclamoService reclamoService;
	
	@GetMapping({ "/reclamos", ""})
	public List<Reclamo> findAll(){
		return reclamoService.findAll();
	}
	
	@GetMapping("/reclamos/{reclamoId}")
	public ResponseEntity<?> getReclamo(@PathVariable int reclamoId) {
		Reclamo reclamo = reclamoService.findById(reclamoId);

		if (reclamo == null) {
			String mensaje = "Edificio no encontrado con ID: " + reclamoId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(reclamo, HttpStatus.OK);
	}
	
	@PostMapping("/reclamos")
	public ResponseEntity<Reclamo> addEdificio(@RequestBody Reclamo reclamo) {
		
		reclamoService.save(reclamo);

		return new ResponseEntity<>(reclamo, HttpStatus.CREATED);
	}
	
	@PutMapping("/reclamos/{reclamoId}")
	public ResponseEntity<?> updateEdificio(@PathVariable int reclamoId, @RequestBody Reclamo reclamo) {

		Reclamo reclamoOld = reclamoService.findById(reclamoId);

		if (reclamoOld == null) {
			String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		reclamoService.update(reclamoId, reclamo);

		return new ResponseEntity<>(reclamo, HttpStatus.OK);
	}
	
	@DeleteMapping("reclamos/{reclamoId}")
	public ResponseEntity<String> deleteEdificio(@PathVariable int reclamoId) {

		Reclamo reclamo = reclamoService.findById(reclamoId);

		if (reclamo == null) {
			String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		reclamoService.deleteById(reclamoId);

		String mensaje = "Reclamo eliminado [usuarioId = " + reclamoId + "]";
		return new ResponseEntity<String>(mensaje, HttpStatus.NO_CONTENT);
	}
}
