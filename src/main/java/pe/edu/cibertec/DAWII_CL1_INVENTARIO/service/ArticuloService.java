package pe.edu.cibertec.DAWII_CL1_INVENTARIO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.repository.ArticuloRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ArticuloService {
    private ArticuloRepository articuloRepository;

    public List<Articulo> listarArticulos(){
        return articuloRepository.findAll();
    }
}
