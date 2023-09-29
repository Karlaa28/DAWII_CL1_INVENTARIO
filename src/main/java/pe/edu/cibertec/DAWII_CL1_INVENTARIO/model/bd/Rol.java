package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int idRol;
    @Column(name = "fechacreacion")
    private Date fechaCreacion;
    @Column(name = "nombrerol")
    private String nombreRol;
    @Column(name = "estado")
    private int estado;
    @Column(name = "descripcion")
    private String descripcion;


}
