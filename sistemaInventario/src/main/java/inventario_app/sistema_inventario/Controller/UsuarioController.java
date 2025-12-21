package inventario_app.sistema_inventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import inventario_app.sistema_inventario.Modelo.Usuario;
import inventario_app.sistema_inventario.Repository.RolRepository;
import inventario_app.sistema_inventario.Repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model modelo) {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        modelo.addAttribute("listaUsuarios", listaUsuarios);
        return "usuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioNuevoUsuario(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("listaRoles", rolRepository.findAll());
        return "usuario_formulario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editarUsuario(@PathVariable Integer id, Model modelo) {
        Usuario usuario = usuarioRepository.findById(id).get();
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("listaRoles", rolRepository.findAll());
        return "usuario_formulario";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }

}
