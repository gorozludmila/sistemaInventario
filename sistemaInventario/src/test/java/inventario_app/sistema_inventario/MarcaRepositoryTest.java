package inventario_app.sistema_inventario;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import inventario_app.sistema_inventario.Modelo.Marca;
import inventario_app.sistema_inventario.Repository.MarcaRepository;

@DataJpaTest
@ActiveProfiles("test")
public class MarcaRepositoryTest {

    @Autowired
    private MarcaRepository repositorio;

    @Test
    void testCrearMarca() {
        Marca marca = repositorio.save(new Marca("LG"));
        assertThat(marca.getId()).isNotNull();
    }
}
