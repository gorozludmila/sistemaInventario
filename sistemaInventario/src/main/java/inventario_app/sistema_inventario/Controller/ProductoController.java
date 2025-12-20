package inventario_app.sistema_inventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import inventario_app.sistema_inventario.Modelo.Producto;
import inventario_app.sistema_inventario.Repository.CategoriaRepository;
import inventario_app.sistema_inventario.Repository.ProductoRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        List<Producto> listaProductos = productoRepository.findAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "producto";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("listaCategorias", categoriaRepository.findAll());
        return "producto_formulario";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto, HttpServletRequest request ) {
        String[] detallesNombres = request.getParameterValues("detallesNombres");
        String[] detallesValores = request.getParameterValues("detallesValores");

       

        productoRepository.save(producto);
        return "redirect:/productos";

    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer id, Model modelo) {
        //Producto producto = productoRepository.findById(id).get();
        Producto producto = productoRepository.findById(id).orElseThrow();
        modelo.addAttribute("producto", producto);
        modelo.addAttribute("listaCategorias", categoriaRepository.findAll());

        return "producto_formulario";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            productoRepository.deleteById(id);
            ra.addFlashAttribute("mensaje", "Producto eliminado correctamente");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se puede eliminar el producto porque está en un carrito");
        }
        return "redirect:/productos";

    }

}
