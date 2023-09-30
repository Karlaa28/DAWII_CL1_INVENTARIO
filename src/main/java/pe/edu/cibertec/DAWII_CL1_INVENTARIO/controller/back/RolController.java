package pe.edu.cibertec.DAWII_CL1_INVENTARIO.controller.back;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Rol;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.service.RolService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/rol")
public class RolController {
    private RolService rolService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Rol> listarRoles(){
        return rolService.listarRoles();
    }
}
