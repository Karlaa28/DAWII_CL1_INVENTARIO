package pe.edu.cibertec.DAWII_CL1_INVENTARIO.controller.back;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Usuario;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.UsuarioRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.UsuarioService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaUsuarios",
                usuarioService.listarUsuarios());
        return "backoffice/usuario/frmMantUsuario";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarUsuario(
            @RequestBody UsuarioRequest usuarioRequest
    ){
        return usuarioService.guardarUsuario(usuarioRequest);
    }
}
