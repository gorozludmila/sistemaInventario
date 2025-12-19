package inventario_app.sistema_inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import inventario_app.sistema_inventario.Modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
