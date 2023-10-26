package grupo8.restapi.app.controllers.edificio;

import grupo8.restapi.app.model.dto.edificio.EdificioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import grupo8.restapi.app.service.intefaces.IEdificioService;
import grupo8.restapi.app.model.entity.edificio.Edificio;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('admin')")
@RequestMapping("api")
public class EdificioController {
    @Autowired
    private IEdificioService edificioService;

    @GetMapping("/edificios")
    public List<EdificioDTO> getAll() {
        List<EdificioDTO> listaEdifcios = new ArrayList<>();

        for (Edificio i :edificioService.getAll()) {
            listaEdifcios.add(parseDTO(i));
        }

        return listaEdifcios;
    }

    @GetMapping("/edificio/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Edificio edificio = edificioService.getById(id);

        if(edificio == null) {
            String mensaje = "El edificio con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(edificio), null, HttpStatus.OK);
    }

    @GetMapping("/edificioParam")
    public ResponseEntity<?> getAdminParam(@RequestParam("edificioId") long edificioId){
        Edificio edificio = edificioService.getById(edificioId);

        if(edificio == null) {
            String mensaje = "El edificio con id " + edificioId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(edificio), null, HttpStatus.OK);
    }

    @PostMapping("/edificio")
    public ResponseEntity<?> addEdificio(@RequestBody Edificio edificio) {
        if(controlEdificioParam(edificio)){
            String mensaje = "El edificio no tiene todos los parametros necesarios";
            return new ResponseEntity<>(mensaje, null, 400);
        }

        edificioService.save(edificio);

        return new ResponseEntity<>(parseDTO(edificio), null, HttpStatus.CREATED);
    }

    @PutMapping("/edificio/{id}")
    public ResponseEntity<?> updateEdificio(@PathVariable long id, @RequestBody EdificioDTO edificioDTO){
        Edificio edificioViejo = edificioService.getById(id);

        if(edificioViejo == null) {
            String mensaje = "El edificio con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Edificio edificio = parseToEntity(edificioDTO);

        if(controlEdificioParam(edificio)){
            String mensaje = "El edificio no tiene todos los parametros necesarios";
            return new ResponseEntity<>(mensaje, null, 400);
        }

        edificioService.update(id, edificio);

        return new ResponseEntity<>(edificioDTO, null, HttpStatus.OK);
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

    // PASER METHODS

    public static EdificioDTO parseDTO(Edificio edificio){
        return new EdificioDTO(edificio.getDireccion(), edificio.getCiudad(), edificio.getCodigoPostal(), edificio.getPais());
    }

    public static Edificio parseToEntity(EdificioDTO edificioDTO){
        Edificio edificio = new Edificio();

        edificio.setDireccion(edificioDTO.getDireccion());
        edificio.setCiudad(edificioDTO.getCiudad());
        edificio.setCodigoPostal(edificioDTO.getCodigoPostal());
        edificio.setPais(edificioDTO.getPais());

        return edificio;
    }

    private boolean controlEdificioParam(Edificio edificio) {
        if(edificio.getDireccion() == null)
            return true;
        return false;
    }

}
