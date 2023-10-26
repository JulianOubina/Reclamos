package api_reclamos_spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api_reclamos_spring.model.dao.IImagenReclamoDAO;
import api_reclamos_spring.model.entity.ImagenReclamo;

@Service
public class ImagenReclamoService implements IImagenReclamoService {
    @Autowired
    private IImagenReclamoDAO imagenReclamoDAO;

    public ImagenReclamo findById(Long id) {
        Optional<ImagenReclamo> imagenReclamoOptional = imagenReclamoDAO.findById(id);
        return imagenReclamoOptional.orElse(null);
    }

    public void save(ImagenReclamo imagenReclamo) {
        imagenReclamoDAO.save(imagenReclamo);
    }

    public void delete(long id) {
        imagenReclamoDAO.deleteById(id);
    }
}
