package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.FuncionRol;

public interface RepositorioFuncionRol extends JpaRepository<FuncionRol,Long>{
	@Query("SELECT c FROM FuncionRol c WHERE c.codigo=:codigo")
	FuncionRol getFuncionRol(@Param(value="codigo")Long codigo);

}
