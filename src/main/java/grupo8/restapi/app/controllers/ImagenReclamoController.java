package grupo8.restapi.app.controllers;

import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import grupo8.restapi.app.service.intefaces.IImagenReclamoService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/imagenreclamo")
public class ImagenReclamoController {
    @Autowired
    private IImagenReclamoService imagenReclamoService;

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
    public ResponseEntity<String> upload(@RequestParam("archivo") MultipartFile archivo) {
        try {
            ImagenReclamo imagenReclamo = new ImagenReclamo();
            imagenReclamo.setDatosImagen(archivo.getBytes());
            imagenReclamoService.save(imagenReclamo);
            return ResponseEntity.ok("Imagen subida exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen.");
        }
    }

}
