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
import api_reclamos_spring.model.entity.ReclamoUnidad;
import api_reclamos_spring.service.IReclamoUnidadService;



@RestController
@RequestMapping("/api")
public class ReclamoUnidadController {
	
	@Autowired
	private IReclamoUnidadService reclamoUnidadService;
	
	@GetMapping({ "/reclamosUnidad", ""})
	public List<ReclamoUnidad> findAll(){
		return reclamoUnidadService.findAll();
	}
	
	@GetMapping("/reclamosUnidad/{reclamoId}")
	public ResponseEntity<?> getReclamo(@PathVariable int reclamoId) {
		ReclamoUnidad reclamo = reclamoUnidadService.findById(reclamoId);

		if (reclamo == null) {
			String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(reclamo, HttpStatus.OK);
	}
	
	@DeleteMapping("reclamosUnidad/{reclamoId}")
	public ResponseEntity<String> deleteReclamo(@PathVariable int reclamoId) {

		ReclamoUnidad reclamo = reclamoUnidadService.findById(reclamoId);

		if (reclamo == null) {
			String mensaje = "Reclamo no encontrado con ID: " + reclamoId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		reclamoUnidadService.deleteById(reclamoId);

		String mensaje = "Reclamo eliminado [usuarioId = " + reclamoId + "]";
		return new ResponseEntity<String>(mensaje, HttpStatus.NO_CONTENT);
	}
}
