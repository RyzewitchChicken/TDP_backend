package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Camion;



public interface RepositorioCamion extends JpaRepository<Camion,Long>{
	@Query("SELECT c FROM Camion c WHERE c.codigo=:codigo")
	Camion getCamion(@Param(value="codigo")Long codigo);

}
