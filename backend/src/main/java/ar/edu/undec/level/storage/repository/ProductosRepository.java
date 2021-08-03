package ar.edu.undec.level.storage.repository;

 import ar.edu.undec.level.storage.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {

        }