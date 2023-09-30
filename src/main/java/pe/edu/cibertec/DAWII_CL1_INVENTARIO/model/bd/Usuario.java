package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "estado")
    private int estado;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "fechanacimiento")
    private java.sql.Date fechaNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idrol")
    private Rol rol;

}


