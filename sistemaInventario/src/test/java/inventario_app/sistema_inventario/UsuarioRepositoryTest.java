package inventario_app.sistema_inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import inventario_app.sistema_inventario.Repository.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;

    /* @Test
    public void testCrearRoles() {

        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");
        entityManager.persist(rolEditor); //lo guardamos en la bd
        entityManager.persist(rolVisitante);
    }

    @Test
    public void testCrearUsuarioConRol() {
        Rol roladmin = entityManager.find(Rol.class, 1);
        Usuario usuario = new Usuario("cristian90@gmail.com", "cristian12");

        usuario.añadirRol(roladmin);
        usuarioRepository.save(usuario);

    }

    @Test
    public void testCrearUsuarioCon2Roles() {
        Rol rolEditor = entityManager.find(Rol.class, 7);
        Rol rolVisitante = entityManager.find(Rol.class, 8);
        Usuario usuario = new Usuario("biaggio202@gmail.com", "122335");

        usuario.añadirRol(rolEditor);
        usuario.añadirRol(rolVisitante);
        usuarioRepository.save(usuario);

    }

    @Test
    public void testAsignarRolAUsuarioExistente() {
        Rol rolEditor = entityManager.find(Rol.class, 7);
        Usuario usuario = usuarioRepository.findById(3).get();

        usuario.añadirRol(rolEditor);
        usuarioRepository.save(usuario);

    }
    @Test
    public void testEliminarRolDeUnUsuario() {
        Usuario usuario = usuarioRepository.findById(3).get();
        Rol rol = new Rol(7); //le pasamos el Id del rol a eliminar
        usuario.eliminarRol(rol);
    }
    @Test
    public void testCrearNuevoUsuarioConNuevoRol() {
        Rol rolVendedor = new Rol("Vendedor");
        Usuario usuario = new Usuario("gabrielram22@gmail.com", "1123");
        usuario.añadirRol(rolVendedor);
        usuarioRepository.save(usuario);
    }
    @Test
    public void testObtenerUsuario() {
        Usuario usuario = usuarioRepository.findById(1).get();
        entityManager.detach(usuario);
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getRoles());
    }*/
    @Test
    public void testEliminarUsuario() {
        usuarioRepository.deleteById(8);
    }
}
