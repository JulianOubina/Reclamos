package grupo8.restapi.app.controllers.reclamo;

import grupo8.restapi.app.model.dto.reclamo.ImagenReclamoDTO;
import grupo8.restapi.app.model.entity.reclamo.Reclamo;
import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;
import grupo8.restapi.app.service.intefaces.IReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import grupo8.restapi.app.service.intefaces.IImagenReclamoService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyAuthority('admin','inquilino','dueno')")
@RequestMapping("/api/imagenreclamo")
public class ImagenReclamoController {
    @Autowired
    private IImagenReclamoService imagenReclamoService;
    @Autowired
    private IReclamosService reclamosService;

    @GetMapping("/{id}")
    public ResponseEntity<?> download(@PathVariable Long id){
        ImagenReclamo imagenReclamo = imagenReclamoService.findById(id);

        if(imagenReclamo != null){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagenReclamo.getDatosImagen());
        }
        else{
            return new ResponseEntity<>("No Se Encontro la foto con el id "+ id ,null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reclamo/{id}")
    public ResponseEntity<?> getImagenesDeReclamo(@PathVariable Long id){
        Reclamo reclamo = reclamosService.findById(id);

        if(reclamo == null){
            return new ResponseEntity<>("No Se Encontro el reclamo con el id "+ id ,null, HttpStatus.BAD_REQUEST);
        }

        List<ImagenReclamo> fotos = reclamosService.findFotos(reclamo);
        List<ImagenReclamoDTO> dto = new ArrayList<>();

        for (ImagenReclamo ir : fotos) {
            dto.add(parseDto(ir));
        }

        return new ResponseEntity<>( dto ,null, HttpStatus.OK);
    }

    @PostMapping("/subir")
    public ResponseEntity<String> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam Long id) {
        try {
            if(reclamosService.findById(id) == null)
                return new ResponseEntity<>("No Se Encontro el reclamo con el id "+ id ,null, HttpStatus.BAD_REQUEST);
            ImagenReclamo imagenReclamo = new ImagenReclamo();
            imagenReclamo.setDatosImagen(archivo.getBytes());
            imagenReclamo.setReclamo(reclamosService.findById(id));
            imagenReclamoService.save(imagenReclamo);
            return ResponseEntity.ok("Imagen subida exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("No Se pudo guardar la foto" ,null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> drop(@PathVariable Long id){
        ImagenReclamo imagenReclamo = imagenReclamoService.findById(id);

        if(imagenReclamo == null){
            return new ResponseEntity<>("No Se Encontro la foto con el id "+ id ,null, HttpStatus.BAD_REQUEST);
        }

        imagenReclamoService.delete(id);

        return ResponseEntity.ok("Imagen eliminada exitosamente.");
    }

    // PARSER DTOS

    private ImagenReclamoDTO parseDto(ImagenReclamo imagenReclamo){
        ImagenReclamoDTO imagenReclamoDTO = new ImagenReclamoDTO();

        imagenReclamoDTO.setId(imagenReclamo.getId());

        imagenReclamoDTO.setIdReclamo(imagenReclamo.getReclamo().getIdReclamo());

        return imagenReclamoDTO;
    }
}
