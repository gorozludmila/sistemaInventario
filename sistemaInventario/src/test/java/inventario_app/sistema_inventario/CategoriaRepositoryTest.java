package inventario_app.sistema_inventario;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import inventario_app.sistema_inventario.Modelo.Categoria;
import inventario_app.sistema_inventario.Modelo.Marca;
import inventario_app.sistema_inventario.Repository.CategoriaRepository;

@DataJpaTest
@ActiveProfiles("test")
class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository repositorio;

    @Test
    void testCrearCategoria() {
        Marca marca = new Marca();
        marca.setId(1);
        marca.setNombre("LG");

        Categoria categoria = repositorio.save(new Categoria("Electronicos", marca));
        assertThat(categoria.getId()).isNotNull();
    }
}
