package grupo8.restapi.app.service.intefaces;

import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;

public interface IImagenReclamoService {
    ImagenReclamo findById(Long id);
    void save(ImagenReclamo imagenReclamo);
    void delete(long id);

}

