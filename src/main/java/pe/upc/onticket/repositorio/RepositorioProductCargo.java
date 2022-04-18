package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.ProductCargo;

public interface RepositorioProductCargo extends JpaRepository<ProductCargo,Long>{
	@Query("SELECT c FROM ProductCargo c WHERE c.codigo=:codigo")
	ProductCargo getProductCargo(@Param(value="codigo")Long codigo);

}
