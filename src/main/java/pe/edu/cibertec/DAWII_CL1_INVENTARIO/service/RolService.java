package pe.edu.cibertec.DAWII_CL1_INVENTARIO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Rol;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.repository.RolRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RolService {
    private RolRepository rolRepository;

    public List<Rol> listarRoles(){
        return rolRepository.findAll();
    }
}
