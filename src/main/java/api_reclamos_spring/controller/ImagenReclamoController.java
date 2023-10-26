package api_reclamos_spring.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import api_reclamos_spring.model.entity.ImagenReclamo;
import api_reclamos_spring.service.IImagenReclamoService;
import api_reclamos_spring.service.IReclamoService;


@RestController
@RequestMapping("/api/imagenreclamo")
public class ImagenReclamoController {
    @Autowired
    private IImagenReclamoService imagenReclamoService;
    @Autowired
    private IReclamoService reclamosService;

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

    @PostMapping("/subir")
    public ResponseEntity<String> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
        try {
            ImagenReclamo imagenReclamo = new ImagenReclamo();
            imagenReclamo.setDatosImagen(archivo.getBytes());
            imagenReclamo.setReclamo(reclamosService.findById(id));
            imagenReclamoService.save(imagenReclamo);
            return ResponseEntity.ok("Imagen subida exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen.");
        }
    }

}
