package pe.edu.cibertec.DAWII_CL1_INVENTARIO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Categoria;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.repository.CategoriaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}
