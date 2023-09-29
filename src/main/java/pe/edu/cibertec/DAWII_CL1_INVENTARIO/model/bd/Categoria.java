package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    private Integer idCategoria;
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
