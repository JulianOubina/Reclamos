package grupo8.restapi.app.service.implementaciones;

import grupo8.restapi.app.model.dao.interfaces.IImagenReclamoDAO;
import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;
import grupo8.restapi.app.service.intefaces.IImagenReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImagenReclamoService implements IImagenReclamoService {
    @Autowired
    private IImagenReclamoDAO imagenReclamoDAO;

    @Override
    public ImagenReclamo findById(Long id) {
        Optional<ImagenReclamo> imagenReclamoOptional = imagenReclamoDAO.findById(id);
        return imagenReclamoOptional.orElse(null);
    }

    @Override
    public void save(ImagenReclamo imagenReclamo) {
        imagenReclamoDAO.save(imagenReclamo);
    }

    @Override
    public void delete(long id) {
        imagenReclamoDAO.deleteById(id);
    }
}
