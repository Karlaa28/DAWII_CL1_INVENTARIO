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
    private int idrol;
    @Column(name = "fechacreacion")
    private Date fechacreacion;
    @Column(name = "nombrerol")
    private String nombrerol;
    @Column(name = "estado")
    private int estado;
    @Column(name = "descripcion")
    private String descripcion;


}
