package inventario_app.sistema_inventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import inventario_app.sistema_inventario.Modelo.Categoria;
import inventario_app.sistema_inventario.Repository.CategoriaRepository;
import inventario_app.sistema_inventario.Repository.MarcaRepository;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("/categorias")
    public String listarCategorias(Model modelo) {
        List<Categoria> listaCategoria = categoriaRepository.findAll();
        modelo.addAttribute("listaCategoria", listaCategoria);
        return "categoria";
    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioNuevaCategoria(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        modelo.addAttribute("listaMarcas", marcaRepository.findAll());
        return "categoria_formulario";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(@ModelAttribute Categoria cat) {
        categoriaRepository.save(cat);
        return "redirect:/categorias";
    }
}
