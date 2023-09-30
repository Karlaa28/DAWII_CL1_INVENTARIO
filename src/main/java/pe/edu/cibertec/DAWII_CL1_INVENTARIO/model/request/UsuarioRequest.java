package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class UsuarioRequest {
    private Integer idusuario;
    private String usuario;
    private String nombre;
    private String apellido;
    private Boolean estado;
    private String telefono;
    private String correo;
    private Integer idrol;
    private String comentario;
}
