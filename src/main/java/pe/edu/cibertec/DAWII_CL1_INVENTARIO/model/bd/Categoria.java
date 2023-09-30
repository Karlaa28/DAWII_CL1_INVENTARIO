package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private Integer idcategoria;

    @Column(name="fechacreacion")
    private Date fechacreacion;

    @Column(name="fechaactualizacion")
    private Date fechaactualizacion;

    @Column(name="estado")
    private int estado;

    @Column(name="comentario")
    private String comentario;

    @Column(name="nombre")
    private String nombre;

}
