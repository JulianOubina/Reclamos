package api_reclamos_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import api_reclamos_spring.model.entity.Edificio;
import api_reclamos_spring.service.IEdificioService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/edificio")
public class EdificioController {

	@Autowired
	private IEdificioService edificioService;

	@GetMapping({ "/edificios", ""})
	public List<Edificio> findAll(){
		return edificioService.findAll();
	}

	@GetMapping("/edificios/{edificioId}")
	public ResponseEntity<?> getEdificio(@PathVariable int edificioId) {
		Edificio edificio = edificioService.findById(edificioId);

		if (edificio == null) {
			String mensaje = "Edificio no encontrado con ID: " + edificioId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(edificio, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Edificio> addEdificio(@RequestBody Edificio edificio) {

		edificioService.save(edificio);

		return new ResponseEntity<>(edificio, HttpStatus.CREATED);
	}

	@PutMapping("/edificios/{edificioId}")
	public ResponseEntity<?> updateEdificio(@PathVariable int edificioId, @RequestBody Edificio edificio) {

		Edificio edificioOld = edificioService.findById(edificioId);

		if (edificioOld == null) {
			String mensaje = "Edificio no encontrado con ID: " + edificioId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		edificioService.update(edificioId, edificio);

		return new ResponseEntity<>(edificio, HttpStatus.OK);
	}

	@DeleteMapping("edificios/{edificioId}")
	public ResponseEntity<String> deleteEdificio(@PathVariable int edificioId) {

		Edificio edificio = edificioService.findById(edificioId);

		if (edificio == null) {
			String mensaje = "Edificio no encontrado con ID: " + edificioId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		edificioService.deleteById(edificioId);

		String mensaje = "Edificio eliminado [usuarioId = " + edificioId + "]";
		return new ResponseEntity<String>(mensaje, HttpStatus.NO_CONTENT);
	}
}
