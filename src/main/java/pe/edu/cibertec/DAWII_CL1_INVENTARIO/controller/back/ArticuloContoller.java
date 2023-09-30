package pe.edu.cibertec.DAWII_CL1_INVENTARIO.controller.back;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.ArticuloRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.ArticuloService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/articulos")
public class ArticuloContoller {
    private ArticuloService articuloServicio;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarArticulos",
                articuloServicio.listarArticulos());
        return "backoffice/articulo/frmMantArticulo";
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarArticulo(
            @RequestBody ArticuloRequest articuloRequest
    ){
        System.out.print("ZZZZZZ");
        return articuloServicio.guardarArticulo(articuloRequest);
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Articulo> listarArticulos(){
        return articuloServicio.listarArticulos();
    }
}
