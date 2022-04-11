package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.FamProducto;



public interface RepositorioFamProducto extends JpaRepository<FamProducto,Long>{
	@Query("SELECT c FROM FamProducto c WHERE c.codigo=:codigo")
	FamProducto getFamProducto(@Param(value="codigo")Long codigo);

}
