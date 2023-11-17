package grupo8.restapi.app.controllers.usuarios;

import grupo8.restapi.app.model.dto.usuarios.InquilinoDTO;
import grupo8.restapi.app.service.implementaciones.UnidadService;
import grupo8.restapi.app.service.intefaces.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import grupo8.restapi.app.service.intefaces.IInquilinoService;
import grupo8.restapi.app.model.entity.usuarios.Inquilino;


import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, origins = "http://localhost:5173", allowedHeaders = "*")
@PreAuthorize("hasAuthority('admin')")
@RequestMapping("api")
public class InquilinoController {
    @Autowired
    private IInquilinoService inquilinoService;
    @Autowired
    private IUnidadService unidadService;

    @GetMapping("/inquilinos")
    public List<InquilinoDTO> getAll() {
        List<InquilinoDTO> inquilinoDTOList = new ArrayList<>();

        for (Inquilino i : inquilinoService.getAll()){
            inquilinoDTOList.add(parseDTO(i));
        }

        return inquilinoDTOList;
    }

    @GetMapping("/inquilino/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Inquilino inquilino = inquilinoService.getById(id);

        if (inquilino == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.OK);
    }

    @GetMapping("/inquilinoParam")
    public ResponseEntity<?> getInquilinoPararm(@RequestParam("inquilinoId") long inquilinoId) {
        Inquilino inquilino = inquilinoService.getById(inquilinoId);

        if (inquilino == null) {
            String mensaje = "El inquilino con id " + inquilinoId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.OK);
    }

    @PostMapping("/inquilino/{id}")
    public ResponseEntity<?> addInquilino(@RequestBody Inquilino inquilino, @PathVariable Long id) {   // TODO METODO SE ROMPE

        if(unidadService.getById(id) == null){
            String mensaje = "La unidad con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        inquilino.setUnidad(unidadService.getById(id));

        if(controlInquilinoParam(inquilino)){
            String mensaje = "No tiene los parametros minimo para ingresarlo";
            return new ResponseEntity<>(mensaje, null, 404);
        }
        if(inquilinoService.findUser(inquilino.getNombreUs(), inquilino.getContraseña()) != null){
            String mensaje = "El inquilino ya existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        inquilinoService.save(inquilino);
        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.CREATED);
    }

    @PutMapping("/inquilino/{id}")
    public ResponseEntity<?> updateInquilino(@PathVariable long id, @RequestBody InquilinoDTO inquilinoDTO) {
        Inquilino inquilinoViejo = inquilinoService.getById(id);

        if (inquilinoViejo == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        if(inquilinoService.existe(inquilinoDTO.getNombreUs()) && !inquilinoDTO.getNombreUs().equals(inquilinoViejo.getNombreUs())){
            String mensaje = "El inquilino ya existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Inquilino inquilino = parseToEntity(inquilinoDTO);

        inquilinoService.update(id, inquilino);

        return new ResponseEntity<>(inquilinoDTO, null, HttpStatus.CREATED);
    }

    @DeleteMapping("/inquilino/{id}")
    public ResponseEntity<String> deleteInquilino(@PathVariable long id){
        Inquilino inquilino = inquilinoService.getById(id);

        if(inquilino == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        inquilinoService.delete(inquilino);

        String mensaje = "El inquilino con id " + id + " fue eliminado";

        return new ResponseEntity<>(mensaje, null, HttpStatus.OK);
    }

    // PASAR ENTITY -> DTO o DTO -> ENTITY //
    private InquilinoDTO parseDTO(Inquilino inquilino){
        InquilinoDTO inquilinoDTO = new InquilinoDTO();

        inquilinoDTO.setNombre(inquilino.getNombre());
        inquilinoDTO.setNombreUs(inquilino.getNombreUs());
        inquilinoDTO.setTelefono(inquilino.getTelefono());
        inquilinoDTO.setEmail(inquilino.getEmail());
        inquilinoDTO.setDirecion(inquilino.getDirecion());

        if (inquilino.getUnidad() != null)
            inquilinoDTO.setIdUnidad(inquilino.getUnidad().getIdUnidad());

        return inquilinoDTO;
    }

    private Inquilino parseToEntity(InquilinoDTO inquilinoDTO){
        Inquilino inquilino = new Inquilino();

        if(inquilinoDTO.getIdInquilino() != null)
            inquilino.setIdUsuario(inquilinoDTO.getIdInquilino());
        inquilino.setNombre(inquilinoDTO.getNombre());
        inquilino.setNombreUs(inquilinoDTO.getNombreUs());
        inquilino.setTelefono(inquilinoDTO.getTelefono());
        inquilino.setEmail(inquilinoDTO.getEmail());
        inquilino.setDirecion(inquilinoDTO.getDirecion());

        if(inquilinoDTO.getIdUnidad() != null) {
            inquilino.setUnidad(unidadService.getById(inquilinoDTO.getIdUnidad()));
        }

        return inquilino;
    }

    // METODOS DE VERIFICACION

    private boolean controlInquilinoParam(Inquilino inquilino) {
        if(inquilino.getNombre() == null)
            return true;
        if(inquilino.getNombreUs() == null)
            return true;
        if(inquilino.getContraseña() == null)
            return true;
        if(inquilino.getUnidad() == null)
            return true;

        return false;
    }
}
