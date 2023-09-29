package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request;

import lombok.Data;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Categoria;
import java.util.Date;

@Data
public class ArticuloRequest {
    private Integer idarticulo;
    private Date fechacreacion;
    private Date fechaactualizacion;
    private int estado;
    private String comentario;
    private String nombre;
    private String descripcion;
    private String codigo;
    private String imagenurl;
    private Double preciounitario;
    private Double precioventa;
    private Categoria categoria;
}
