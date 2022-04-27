package pe.upc.onticket.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Producto;


public interface RepositorioProducto extends JpaRepository<Producto,Long>{
	
	@Query("SELECT c FROM Producto c WHERE c.codigo=:codigo")
	Producto getProducto(@Param(value="codigo")Long codigo);
	
	
	@Query("SELECT c.famproducto FROM Producto c WHERE c.codigo=:codigo")
	List<Object[]> getFamProducto(@Param(value="codigo")Long codigo);

	@Query("SELECT c FROM Producto c WHERE c.famproducto.codigo=:codigo")
	List<Producto> getProductsByFamProductoId(@Param(value="codigo")Long codigo);

}
