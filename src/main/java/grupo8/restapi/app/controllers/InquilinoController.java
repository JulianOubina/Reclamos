package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.dto.usuarios.InquilinoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import grupo8.restapi.app.service.intefaces.IInquilinoService;
import grupo8.restapi.app.model.entity.usuarios.Inquilino;

import static grupo8.restapi.app.extra.Parser.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class InquilinoController {
    @Autowired
    private IInquilinoService inquilinoService;

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

    @PostMapping("/inquilino")
    public ResponseEntity<?> addInquilino(@RequestBody Inquilino inquilino) {
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
//    private InquilinoDTO parseDTO(Inquilino inquilino){
//        return new InquilinoDTO(inquilino.getNombre(), inquilino.getNombreUs(), inquilino.getTelefono(), inquilino.getEmail(), inquilino.getDirecion(), inquilino.getUnidad());
//    }
//
//    private Inquilino parseToEntity(InquilinoDTO inquilinoDTO){
//        Inquilino inquilino = new Inquilino();
//
//        inquilino.setNombre(inquilinoDTO.getNombre());
//        inquilino.setNombreUs(inquilinoDTO.getNombreUs());
//        inquilino.setTelefono(inquilinoDTO.getTelefono());
//        inquilino.setEmail(inquilinoDTO.getEmail());
//        inquilino.setDirecion(inquilinoDTO.getDirecion());
//        inquilino.setUnidad(inquilinoDTO.getUnidad());
//
//        return inquilino;
//    }
}
