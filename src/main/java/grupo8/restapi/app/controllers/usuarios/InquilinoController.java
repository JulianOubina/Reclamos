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
@RequestMapping("api")
public class InquilinoController {
    @Autowired
    private IInquilinoService inquilinoService;
    @Autowired
    private IUnidadService unidadService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/inquilinos")
    public List<InquilinoDTO> getAll() {
        List<InquilinoDTO> inquilinoDTOList = new ArrayList<>();

        for (Inquilino i : inquilinoService.getAll()){
            inquilinoDTOList.add(parseDTO(i));
        }

        return inquilinoDTOList;
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/inquilino/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Inquilino inquilino = inquilinoService.getById(id);

        if (inquilino == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/inquilinoParam")
    public ResponseEntity<?> getInquilinoPararm(@RequestParam("inquilinoId") long inquilinoId) {
        Inquilino inquilino = inquilinoService.getById(inquilinoId);

        if (inquilino == null) {
            String mensaje = "El inquilino con id " + inquilinoId + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/inquilino")
    public ResponseEntity<?> addInquilino(@RequestBody Inquilino inquilino) {   // TODO METODO SE ROMPE
        inquilinoService.save(inquilino);
        return new ResponseEntity<>(parseDTO(inquilino), null, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping("/inquilino/{id}")
    public ResponseEntity<?> updateInquilino(@PathVariable long id, @RequestBody InquilinoDTO inquilinoDTO) {
        Inquilino inquilinoViejo = inquilinoService.getById(id);

        if (inquilinoViejo == null) {
            String mensaje = "El inquilino con id " + id + " no existe";
            return new ResponseEntity<>(mensaje, null, 404);
        }

        Inquilino inquilino = parseToEntity(inquilinoDTO);

        inquilinoService.update(id, inquilino);

        return new ResponseEntity<>(inquilinoDTO, null, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('admin')")
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
}
