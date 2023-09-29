package pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "articulo")
public class Articulo {
    @Id
    private Integer idarticulo;
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
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="codigo")
    private String codigo;
    @Column(name="imagenurl")
    private String imagenurl;
    @Column(name="preciounitario")
    private Double preciounitario;
    @Column(name="precioventa")
    private Double precioventa;
    @ManyToOne
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;
}
