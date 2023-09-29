package pe.edu.cibertec.DAWII_CL1_INVENTARIO.controller.back;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.ArticuloService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/articulo")
public class ArticuloContoller {
    private ArticuloService articuloServicio;

    @GetMapping("/listar")
    @ResponseBody
    public List<Articulo> listarArticulos(){
        return articuloServicio.listarArticulos();
    }
}
