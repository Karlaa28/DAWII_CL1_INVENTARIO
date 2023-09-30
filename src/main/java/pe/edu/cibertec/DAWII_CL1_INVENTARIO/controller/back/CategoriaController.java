package pe.edu.cibertec.DAWII_CL1_INVENTARIO.controller.back;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Categoria;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.ArticuloRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.CategoriaRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.ArticuloService;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.CategoriaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaService categoriaService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarCategorias",
                categoriaService.listarCategorias());
        return "backoffice/categoria/frmMantCategoria";
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarArticulo(
            @RequestBody CategoriaRequest categoriaRequest
    ){
        return categoriaService.guardarCategoria(categoriaRequest);
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }
}
