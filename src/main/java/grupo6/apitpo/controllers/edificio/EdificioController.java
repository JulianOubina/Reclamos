package grupo6.apitpo.controllers.edificio;

import grupo6.apitpo.model.dto.edificio.EdificioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import grupo6.apitpo.service.intefaces.IEdificioService;
import grupo6.apitpo.model.entity.Edificio;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("edificios")
public class EdificioController {
    @Autowired
    private IEdificioService edificioService;

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
    public List<EdificioDTO> getAll() {
        List<EdificioDTO> listaEdifcios = new ArrayList<>();

        for (Edificio i :edificioService.getAll()) {
            listaEdifcios.add(parseDTO(i));
        }

        return listaEdifcios;
    }

    @GetMapping("/searchById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Edificio edificio = edificioService.getById(id);

        if(edificio == null) {
            String mensaje = "El edificio con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(edificio), null, HttpStatus.OK);
    }

    @GetMapping("/edificioParam")
    public ResponseEntity<?> getAdminParam(@RequestParam("edificioId") Integer edificioId){
        Edificio edificio = edificioService.getById(edificioId);

        if(edificio == null) {
            String mensaje = "El edificio con id " + edificioId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(edificio), null, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEdificio(@RequestBody Edificio edificio) {
        if(controlEdificioParam(edificio)){
            String mensaje = "El edificio no tiene todos los parametros necesarios";
            return new ResponseEntity<>(mensaje, null, 400);
        }

        edificioService.save(edificio);

        return new ResponseEntity<>(parseDTO(edificio), null, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEdificio(@PathVariable Integer id, @RequestBody EdificioDTO edificioDTO){
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEdificio(@PathVariable Integer id){
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
        return new EdificioDTO(edificio.getIdEdificio(), edificio.getDireccion(), edificio.getCiudad(), edificio.getCodigoPostal(), edificio.getPais());
    }

    public static Edificio parseToEntity(EdificioDTO edificioDTO){
        Edificio edificio = new Edificio();

        edificioDTO.setIdEdificio(edificio.getIdEdificio());
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
