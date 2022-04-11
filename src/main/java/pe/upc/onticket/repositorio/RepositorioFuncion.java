package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Funcion;



public interface RepositorioFuncion extends JpaRepository<Funcion,Long>{
	
	@Query("SELECT c FROM Funcion c WHERE c.codigo=:codigo")
	Funcion getFuncion(@Param(value="codigo")Long codigo);
	

}
