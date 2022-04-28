package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Cargo;
import pe.upc.onticket.entity.ProductCargo;

import java.util.List;

public interface RepositorioProductCargo extends JpaRepository<ProductCargo,Long>{
	@Query("SELECT c FROM ProductCargo c WHERE c.codigo=:codigo")
	ProductCargo getProductCargo(@Param(value="codigo")Long codigo);


	@Query("SELECT c FROM ProductCargo c WHERE c.cargo.codigo=:codigo")
	List<ProductCargo> getProductCargoByCargoId(@Param(value="codigo")Long codigo);

}
