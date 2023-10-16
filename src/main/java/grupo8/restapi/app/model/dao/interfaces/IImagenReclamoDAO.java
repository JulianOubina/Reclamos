package grupo8.restapi.app.model.dao.interfaces;

import grupo8.restapi.app.model.entity.reclamo.imagen.ImagenReclamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenReclamoDAO extends JpaRepository<ImagenReclamo, Long> {
}
