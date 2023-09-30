package pe.edu.cibertec.DAWII_CL1_INVENTARIO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Categoria;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.ArticuloRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.CategoriaRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.repository.CategoriaRepository;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public ResultadoResponse guardarCategoria(CategoriaRequest categoria){

        String mensaje = "Categoria  registrado correctamente";
        Boolean respuesta = true;
        try {
            Categoria objCategoria = new Categoria();
            if(categoria.getIdcategoria() > 0){
                objCategoria.setIdcategoria(categoria.getIdcategoria());
                objCategoria.setFechaactualizacion(new Date());
            }else{
                objCategoria.setFechaactualizacion(new Date());
                objCategoria.setFechaactualizacion(new Date());
            }
            objCategoria.setNombre(categoria.getNombre());
            objCategoria.setComentario(categoria.getComentario());
            categoriaRepository.save(objCategoria);
        }catch (Exception ex){
            mensaje = "Categoria no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}
