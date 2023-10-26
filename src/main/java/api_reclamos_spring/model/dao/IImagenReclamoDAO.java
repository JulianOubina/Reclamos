package api_reclamos_spring.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import api_reclamos_spring.model.entity.ImagenReclamo;

public interface IImagenReclamoDAO extends JpaRepository<ImagenReclamo, Long> {
}
