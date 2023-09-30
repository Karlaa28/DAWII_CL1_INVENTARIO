package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request;
import lombok.Data;
import java.util.Date;

@Data
public class CategoriaRequest {
    private Integer idcategoria;
    private Date fechacreacion;
    private Date fechaactualizacion;
    private int estado;
    private String comentario;
    private String nombre;
}
