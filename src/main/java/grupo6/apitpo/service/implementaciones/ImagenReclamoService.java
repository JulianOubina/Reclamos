package grupo6.apitpo.service.implementaciones;

import grupo6.apitpo.model.dao.interfaces.IImagenReclamoDAO;
import grupo6.apitpo.model.entity.ImagenReclamo;
import grupo6.apitpo.service.intefaces.IImagenReclamoService;
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
    public void delete(Long id) {
        imagenReclamoDAO.deleteById(id);
    }
}
