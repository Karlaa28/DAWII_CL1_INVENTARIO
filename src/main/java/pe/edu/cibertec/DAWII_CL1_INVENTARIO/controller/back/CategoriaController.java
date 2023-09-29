package pe.edu.cibertec.DAWII_CL1_INVENTARIO.controller.back;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Categoria;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.ArticuloService;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.CategoriaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }
}
