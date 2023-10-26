package api_reclamos_spring.service;

import api_reclamos_spring.model.entity.ImagenReclamo;

public interface IImagenReclamoService {
    ImagenReclamo findById(Long id);
    void save(ImagenReclamo imagenReclamo);
    void delete(long id);

}
