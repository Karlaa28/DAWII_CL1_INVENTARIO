package pe.edu.cibertec.DAWII_CL1_INVENTARIO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_INVENTARIO.model.bd.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {
}
