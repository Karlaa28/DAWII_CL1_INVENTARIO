package pe.edu.cibertec.DAWII_CL1_INVENTARIO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Articulo;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Categoria;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request.ArticuloRequest;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.repository.ArticuloRepository;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.response.ResultadoResponse;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ArticuloService {
    private ArticuloRepository articuloRepository;

    public ResultadoResponse guardarArticulo(ArticuloRequest articulo){

        String mensaje = "Artículo  registrado correctamente";
        Boolean respuesta = true;
        try {
            Articulo objArticulo = new Articulo();
            if(articulo.getIdarticulo() > 0){
                objArticulo.setIdarticulo(articulo.getIdarticulo());
                objArticulo.setFechaactualizacion(new Date());
            }else{
                objArticulo.setFechaactualizacion(new Date());
                objArticulo.setFechaactualizacion(new Date());
            }
            Categoria categoria = new Categoria();
            categoria.setIdcategoria(articulo.getIdcategoria());
            objArticulo.setNombre(articulo.getNombre());
            objArticulo.setCodigo(articulo.getCodigo());
            objArticulo.setPreciounitario(articulo.getPreciounitario());
            objArticulo.setPrecioventa(articulo.getPrecioventa());
            objArticulo.setCategoria(categoria);
            articuloRepository.save(objArticulo);
        }catch (Exception ex){
            mensaje = "Articulo no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
    public List<Articulo> listarArticulos(){
        return articuloRepository.findAll();
    }
}
