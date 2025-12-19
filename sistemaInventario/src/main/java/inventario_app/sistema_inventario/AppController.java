package inventario_app.sistema_inventario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String verPaginaInicio() {
        return "index";
    }
}
