package grupo6.apitpo.service.intefaces;

import grupo6.apitpo.model.entity.ImagenReclamo;

public interface IImagenReclamoService {

    ImagenReclamo findById(Long id);
    void save(ImagenReclamo imagenReclamo);
    void delete(Long id);
}

