package grupo6.apitpo.controllers.usuarios;

import grupo6.apitpo.model.dto.usuarios.InquilinoDTO;
import grupo6.apitpo.model.dtoSinReferencias.usuarios.InquilinoDTOSinRef;
import grupo6.apitpo.service.intefaces.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import grupo6.apitpo.service.intefaces.IInquilinoService;
import grupo6.apitpo.model.entity.Inquilino;


import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("inquilino")
public class InquilinoController {
    @Autowired
    private IInquilinoService inquilinoService;
    @Autowired
    private IUnidadService unidadService;

    @GetMapping("/search")
    public List<InquilinoDTO> getAll() {
        List<InquilinoDTO> inquilinoDTOList = new ArrayList<>();

        for (Inquilino i : inquilinoService.getAll()){
            inquilinoDTOList.add(parseDTO(i));
        }

        return inquilinoDTOList;
    }

    @GetMapping("/searchAll")
    public List<InquilinoDTOSinRef> getAllSinRef() {
        List<InquilinoDTOSinRef> inquilinoDTOList = new ArrayList<>();

        for (Inquilino i : inquilinoService.getAll()){
            inquilinoDTOList.add(parseDTOSinRef(i));
        }

        return inquilinoDTOList;
    }



    @GetMapping("/searchById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Inquilino inquilino = inquilinoService.getById(id);

        if (inquilino == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.OK);
    }

    @GetMapping("/inquilinoParam")
    public ResponseEntity<?> getInquilinoPararm(@RequestParam("inquilinoId") Integer inquilinoId) {
        Inquilino inquilino = inquilinoService.getById(inquilinoId);

        if (inquilino == null) {
            String mensaje = "El inquilino con id " + inquilinoId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.OK);
    }

    @PostMapping("/addToUnidad/{id}")
    public ResponseEntity<?> addInquilino(@RequestBody Inquilino inquilino, @PathVariable Integer id) {

        if(unidadService.getById(id) == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        inquilino.setUnidad(unidadService.getById(id));

        if(controlInquilinoParam(inquilino)){
            String mensaje = "No tiene los parametros minimo para ingresarlo";
            return new ResponseEntity<>(mensaje, null, 404);
        }
        if(inquilinoService.findUser(inquilino.getNombreUsuario(), inquilino.getContraseña()) != null){
            String mensaje = "El inquilino ya existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        inquilinoService.save(inquilino);
        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInquilino(@RequestBody Inquilino inquilino) {
        if(controlInquilinoParam(inquilino)){
            String mensaje = "No tiene los parámetros mínimos para ingresarlo";
            return new ResponseEntity<>(mensaje, null, HttpStatus.BAD_REQUEST);
        }

        if(inquilinoService.findUser(inquilino.getNombreUsuario(), inquilino.getContraseña()) != null){
            String mensaje = "El inquilino ya existe";
            return new ResponseEntity<>(mensaje, null, HttpStatus.CONFLICT);
        }

        inquilinoService.save(inquilino);
        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInquilino(@PathVariable Integer id, @RequestBody InquilinoDTO inquilinoDTO) {
        Inquilino inquilinoViejo = inquilinoService.getById(id);

        if (inquilinoViejo == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        if(inquilinoService.existe(inquilinoDTO.getNombreUsuario()) && !inquilinoDTO.getNombreUsuario().equals(inquilinoViejo.getNombreUsuario())){
            String mensaje = "El inquilino ya existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Inquilino inquilino = parseToEntity(inquilinoDTO);

        inquilinoService.update(id, inquilino);

        return new ResponseEntity<>(inquilinoDTO, null, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInquilino(@PathVariable Integer id){
        Inquilino inquilino = inquilinoService.getById(id);

        if(inquilino == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        inquilinoService.delete(inquilino);

        String mensaje = "El inquilino con id " + id + " fue eliminado";

        return new ResponseEntity<>(mensaje, null, HttpStatus.OK);
    }

    private InquilinoDTOSinRef parseDTOSinRef(Inquilino i) {
        InquilinoDTOSinRef inquilinoDTOSinRef = new InquilinoDTOSinRef();

        inquilinoDTOSinRef.setIdInquilino(i.getIdUsuario());
        inquilinoDTOSinRef.setNombre(i.getNombre());
        inquilinoDTOSinRef.setNombreUsuario(i.getNombreUsuario());
        inquilinoDTOSinRef.setTelefono(i.getTelefono());

        inquilinoDTOSinRef.setDireccion(i.getDireccion());
        inquilinoDTOSinRef.setUnidad(i.getUnidad().getPiso() + " " + i.getUnidad().getDepartamento());

        return inquilinoDTOSinRef;
    }

    private InquilinoDTO parseDTO(Inquilino inquilino){
        InquilinoDTO inquilinoDTO = new InquilinoDTO();

        inquilinoDTO.setIdInquilino(inquilino.getIdUsuario());
        inquilinoDTO.setNombre(inquilino.getNombre());
        inquilinoDTO.setNombreUsuario(inquilino.getNombreUsuario());
        inquilinoDTO.setTelefono(inquilino.getTelefono());

        inquilinoDTO.setDireccion(inquilino.getDireccion());

        if (inquilino.getUnidad() != null)
            inquilinoDTO.setIdUnidad(inquilino.getUnidad().getIdUnidad());

        return inquilinoDTO;
    }

    private Inquilino parseToEntity(InquilinoDTO inquilinoDTO){
        Inquilino inquilino = new Inquilino();

        if(inquilinoDTO.getIdInquilino() != null)
            inquilino.setIdUsuario(inquilinoDTO.getIdInquilino());
        inquilino.setNombre(inquilinoDTO.getNombre());
        inquilino.setNombreUsuario(inquilinoDTO.getNombreUsuario());
        inquilino.setTelefono(inquilinoDTO.getTelefono());
        inquilino.setDireccion(inquilinoDTO.getDireccion());

        if(inquilinoDTO.getIdUnidad() != null) {
            inquilino.setUnidad(unidadService.getById(inquilinoDTO.getIdUnidad()));
        }

        return inquilino;
    }

    private boolean controlInquilinoParam(Inquilino inquilino) {
        if(inquilino.getNombre() == null)
            return true;
        if(inquilino.getNombreUsuario() == null)
            return true;
        if(inquilino.getContraseña() == null)
            return true;
        return false;
    }
}
