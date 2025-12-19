package inventario_app.sistema_inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inventario_app.sistema_inventario.Modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    public boolean existsByMarcaId(Integer id);

}
