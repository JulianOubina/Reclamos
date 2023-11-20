package api_reclamos_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api_reclamos_spring.model.entity.Unidad;
import api_reclamos_spring.service.IUnidadService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UnidadController {
	
	@Autowired
	private IUnidadService unidadService;
	
	@GetMapping({ "/unidades", ""})
	public List<Unidad> findAll(){
		return unidadService.findAll();
	}
	
	@GetMapping("/unidades/{unidadId}")
	public ResponseEntity<?> getUnidad(@PathVariable int unidadId) {
		Unidad unidad = unidadService.findById(unidadId);

		if (unidad == null) {
			String mensaje = "Unidad no encontrada con ID: " + unidadId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(unidad, HttpStatus.OK);
	}
	
	@PostMapping("/unidades")
	public ResponseEntity<Unidad> addUsuario(@RequestBody Unidad unidad) {
		
		unidadService.save(unidad);

		return new ResponseEntity<>(unidad, HttpStatus.CREATED);
	}
	
	@PutMapping("/unidades/{unidadId}")
	public ResponseEntity<?> updateUnidad(@PathVariable int unidadId, @RequestBody Unidad unidad) {

		Unidad unidadOld = unidadService.findById(unidadId);

		if (unidadOld == null) {
			String mensaje = "Unidad no encontrada con ID: " + unidadId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		unidadService.update(unidadId, unidad);

		return new ResponseEntity<>(unidad, HttpStatus.OK);
	}
	
	@DeleteMapping("unidades/{usuarioId}")
	public ResponseEntity<String> deleteUnidad(@PathVariable int unidadId) {

		Unidad unidad = unidadService.findById(unidadId);

		if (unidad == null) {
			String mensaje = "Unidad no encontrado con ID: " + unidadId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		unidadService.deleteById(unidadId);

		String mensaje = "Unidad eliminada [usuarioId = " + unidadId + "]";
		return new ResponseEntity<String>(mensaje, HttpStatus.NO_CONTENT);
	}
}
