package inventario_app.sistema_inventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import inventario_app.sistema_inventario.Modelo.Marca;
import inventario_app.sistema_inventario.Repository.CategoriaRepository;
import inventario_app.sistema_inventario.Repository.MarcaRepository;

@Controller
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/marcas")
    public String listarMarcas(Model modelo) {
        List<Marca> listaMarcas = marcaRepository.findAll();
        modelo.addAttribute("listaMarca", listaMarcas);
        return "marcas";
    }

    @GetMapping("/marcas/nuevo")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("listaCategorias", categoriaRepository.findAll());
        modelo.addAttribute("marca", new Marca());
        return "marca_formulario";
    }

    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca) {
        marcaRepository.save(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/marcas/editar/{id}")
    public String editarMarca(@PathVariable Integer id, Model modelo) {
        Marca marca = marcaRepository.findById(id).orElse(null);
        modelo.addAttribute("marca", marca);
        return "marca_formulario";
    }

    @GetMapping("/marcas/eliminar/{id}")
    public String eliminarMarca(@PathVariable Integer id, RedirectAttributes ra) {
        if (categoriaRepository.existsByMarcaId(id)) {
            ra.addFlashAttribute("error", "No se puede eliminar la marca porque tiene categorias asociadas");
        }
        marcaRepository.deleteById(id);
        return "redirect:/marcas";
    }

}
